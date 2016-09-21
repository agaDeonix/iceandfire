package ru.androidschool.iceandfire.screen.books;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.widget.BaseAdapter;

/**
 * Created by deonix on 21/09/16.
 */

public class BooksAdapter extends BaseAdapter<BookHolder, Book> {

    public BooksAdapter(@NonNull List<Book> items) {
        super(items);
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false));
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Book book = getItem(position);
        holder.bind(book);
    }
}
