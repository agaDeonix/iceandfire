package ru.androidschool.iceandfire.screen.books;

import java.util.List;

import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.screen.general.LoadingView;

/**
 * Created by deonix on 21/09/16.
 */

public interface BooksView extends LoadingView {

    void showError();

    void showCharacters(Book book);

    void showBooks(List<Book> books);
}
