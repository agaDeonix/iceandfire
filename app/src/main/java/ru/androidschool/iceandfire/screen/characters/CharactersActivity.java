package ru.androidschool.iceandfire.screen.characters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.androidquery.AQuery;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.screen.character.CharacterActivity;
import ru.androidschool.iceandfire.screen.general.LoadingDialog;
import ru.androidschool.iceandfire.screen.general.LoadingView;
import ru.androidschool.iceandfire.widget.BaseAdapter;
import ru.androidschool.iceandfire.widget.EmptyRecyclerView;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;

/**
 * Created by deonix on 23/09/16.
 */

public class CharactersActivity extends AppCompatActivity implements BaseAdapter.OnItemClickListener<Character>,CharactersView {

    private static final String BOOK_ID_KEY = "BOOK_ID_KEY";
    private AQuery mAq;
    private CharactersPresenter presenter;
    private LoadingView loadingView;
    private CharactersAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        mAq = new AQuery(this);
        Toolbar toolbar = (Toolbar) mAq.id(R.id.toolbar).getView();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
        loadingView= LoadingDialog.view(getSupportFragmentManager());

        EmptyRecyclerView recyclerView=(EmptyRecyclerView)mAq.id(R.id.characters_list).getView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setEmptyView(mAq.id(R.id.characters_empty).getView());

        adapter=new CharactersAdapter(new ArrayList<>());
        adapter.attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(this);

        LifecycleHandler lifecycleHandler=LoaderLifecycleHandler.create(this,getSupportLoaderManager());
        presenter=new CharactersPresenter(lifecycleHandler,this);
        presenter.init(getIntent().getStringExtra(BOOK_ID_KEY));
    }

    @Override
    public void onItemClick(@NonNull Character item) {
        presenter.onItemClick(item);
    }

    @Override
    public void showError() {
        adapter.clear();
    }

    @Override
    public void showCharacters(List<Character> characters){
        Log.d("kjhj","jhjh");
        adapter.changeDataSet(characters);
    }

    @Override
    public void showCharacter(Character character) {
        CharacterActivity.start(this,character);
    }

    @Override
    public void showLoading() {
        loadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        loadingView.hideLoading();
    }

    public static void start(Activity activity, Book book){
        Intent intent = new Intent(activity, CharactersActivity.class);
        intent.putExtra(BOOK_ID_KEY, book.getUrl());
        activity.startActivity(intent);
    }
}
