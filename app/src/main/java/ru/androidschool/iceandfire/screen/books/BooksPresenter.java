package ru.androidschool.iceandfire.screen.books;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.RealmString;
import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * Created by deonix on 21/09/16.
 */

public class BooksPresenter {
    private final LifecycleHandler mLifecycleHandler;
    private final BooksView mView;

    public BooksPresenter(@NonNull LifecycleHandler lifecycleHandler,
                                 @NonNull BooksView view) {
        mLifecycleHandler = lifecycleHandler;
        mView = view;
    }

    public void init() {
//        BookProvider.provideBookRepository()
//                .repositories()
//                .doOnSubscribe(mView::showLoading)
//                .doOnTerminate(mView::hideLoading)
//                .compose(mLifecycleHandler.load(R.id.repositories_request))
//                .subscribe(mView::showRepositories, throwable -> mView.showError());
        mView.showBooks(getTestBooks());
    }

    private List<Book> getTestBooks() {
        List<Book> result = new ArrayList<>();
        RealmList<RealmString> authors = new RealmList<>();
        authors.add(new RealmString("George R. R. Martin"));
        result.add(Book.create("http://www.anapioficeandfire.com/api/books/1", "A Game of Thrones", "978-0553103540", authors, 694, "Bantam Books", "United States", "Hardcover", "1996-08-01T00:00:00", null, null));
        result.add(Book.create("http://www.anapioficeandfire.com/api/books/2", "A Clash of Kings", "978-0553108033", authors, 768, "Bantam Books", "United States", "Hardcover", "1999-02-02T00:00:00", null, null));
        result.add(Book.create("http://www.anapioficeandfire.com/api/books/3", "A Storm of Swords", "978-0553106633", authors, 992, "Bantam Books", "United States", "Hardcover", "2000-10-31T00:00:00", null, null));
        result.add(Book.create("http://www.anapioficeandfire.com/api/books/4", "The Hedge Knight", "978-0976401100", authors, 164, "Bantam Books", "United States", "Hardcover", "2005-03-09T00:00:00", null, null));
        result.add(Book.create("http://www.anapioficeandfire.com/api/books/5", "A Feast for Crows", "978-0553801507", authors, 784, "Bantam Books", "United States", "Hardcover", "", null, null));
        return result;
    }

    public void onItemClick(@NonNull Book book) {
        mView.showCharacters(book);
    }
}
