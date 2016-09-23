package ru.androidschool.iceandfire.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import rx.Observable;

/**
 * Created by deonix on 21/09/16.
 */

public interface IceAndFireService {

    @GET("books?pageSize=50")
    Observable<List<Book>> getBooks();

    @GET("characters/{character}")
    Observable<Character> getCharacter(@Path("character") String characters);
}
