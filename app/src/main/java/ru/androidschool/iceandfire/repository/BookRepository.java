package ru.androidschool.iceandfire.repository;

import java.util.List;

import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import rx.Observable;

/**
 * @author Azat Galiullin
 */

public interface BookRepository {

    Observable<List<Book>> getBooks();
    Observable<List<Character>> getCharacters(int bookId);
    Observable<Character> getCharacter(int id);

}
