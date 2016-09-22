package ru.androidschool.iceandfire.screen.characters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;

/**
 * Created by deonix on 23/09/16.
 */

public class CharactersActivity extends AppCompatActivity {

    private static final String BOOK_ID_KEY = "BOOK_ID_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
    }

    public static void start(Activity activity, Book book){
        Intent intent = new Intent(activity, CharactersActivity.class);
        intent.putExtra(BOOK_ID_KEY, book.getUrl());
        activity.startActivity(intent);
    }
}
