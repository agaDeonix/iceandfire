package ru.androidschool.iceandfire.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.androidschool.iceandfire.api.ApiFactory;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.content.RealmString;
import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

/**
 * @author Azat Galiullin
 */

public class DefaultBookRepository implements BookRepository {


    @Override
    public Observable<List<Book>> getBooks() {
        Realm realm=Realm.getDefaultInstance();
        if (realm.where(Book.class).count()!=0){
            return Observable.just(realm.copyFromRealm(realm.where(Book.class).findAll()))
                    .compose(RxUtils.async());
        }
        return ApiFactory.getIceAndFireService()
                .getBooks()
                .flatMap(books -> {
                    Realm.getDefaultInstance().executeTransaction(realm1 -> realm1.insert(books));
                    return Observable.just(books);
                })
                .compose(RxUtils.async());
    }

    @Override
    public Observable<List<Character>> getCharacters(int bookId) {
        String urlId="https://anapioficeandfire.com/api/books/".concat(bookId+"");
        Realm realm=Realm.getDefaultInstance();
        return Observable.just(realm.copyFromRealm(realm.where(Book.class).contains("mUrl",urlId).findFirst()))
               .flatMap(book -> {
                   List<Observable<Character>> observableList=new ArrayList<Observable<Character>>();
                   for (RealmString s:book.getCharacters()){
                       observableList.add(getCharacter(Character.getIdFromUrl(s.value)));
                   }
                   return Observable.concat(observableList)
                           .toList()
                           .compose(RxUtils.async());
               });
    }

    @Override
    public Observable<Character> getCharacter(int id) {
        String urlId="https://anapioficeandfire.com/api/characters/".concat(id+"");
        Realm realm=Realm.getDefaultInstance();
        return Observable.just(realm.copyFromRealm(realm.where(Character.class).contains("mUrl",urlId).findFirst()))
                .flatMap(character -> {
                    if (character==null){
                       return ApiFactory.getIceAndFireService()
                               .getCharacter(id+"")
                               .flatMap(character1 -> {
                                   Realm.getDefaultInstance().executeTransaction(realm1 -> realm1.insert(character1));
                                   return Observable.just(character1);
                               });
                    }else{
                        return Observable.just(character);
                    }
                })
                .compose(RxUtils.async());
    }
}