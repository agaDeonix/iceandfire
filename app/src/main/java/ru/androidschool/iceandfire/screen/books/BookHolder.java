package ru.androidschool.iceandfire.screen.books;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidquery.AQuery;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;

/**
 * Created by deonix on 21/09/16.
 */

public class BookHolder extends RecyclerView.ViewHolder {

    private AQuery mAq;

    public BookHolder(View itemView) {
        super(itemView);
        mAq = new AQuery(itemView);
    }

    public void bind(@NonNull Book book) {
        mAq.id(R.id.name).text(book.getName());
    }
}
