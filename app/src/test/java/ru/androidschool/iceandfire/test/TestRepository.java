package ru.androidschool.iceandfire.test;

import java.util.List;

import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.repository.BookRepository;
import rx.Observable;

/**
 * @author Azat Galiullin
 */

public class TestRepository implements BookRepository {
    @Override
    public Observable<List<Book>> getBooks() {
        return null;
    }

    @Override
    public Observable<List<Character>> getCharacters(int bookId) {
        return null;
    }

    @Override
    public Observable<Character> getCharacter(int id) {
        return null;
    }
}
