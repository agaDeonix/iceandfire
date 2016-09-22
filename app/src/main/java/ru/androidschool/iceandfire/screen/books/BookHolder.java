package ru.androidschool.iceandfire.screen.books;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidquery.AQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.RealmString;

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
        mAq.id(R.id.cover).image(String.format("http://covers.openlibrary.org/b/isbn/%s-M.jpg", book.getIsbn()));
        mAq.id(R.id.isbn).text(book.getIsbn());
        mAq.id(R.id.page_count).text(book.getNumberOfPages().toString());
        String authors = "";
        for(RealmString author: book.getAuthors()){
            authors += "\n" + author.value;
        }
        mAq.id(R.id.authors).text(authors.substring(1));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat outFormat = new SimpleDateFormat("dd MMMM yyyy");
        try {
            Date date = format.parse(book.getReleased());
            mAq.id(R.id.year).text(outFormat.format(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
