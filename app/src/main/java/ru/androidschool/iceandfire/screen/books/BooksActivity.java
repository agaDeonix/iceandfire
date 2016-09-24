package ru.androidschool.iceandfire.screen.books;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.androidquery.AQuery;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.screen.characters.CharactersActivity;
import ru.androidschool.iceandfire.screen.general.LoadingDialog;
import ru.androidschool.iceandfire.screen.general.LoadingView;
import ru.androidschool.iceandfire.widget.BaseAdapter;
import ru.androidschool.iceandfire.widget.EmptyRecyclerView;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;

/**
 * Created by deonix on 21/09/16.
 */

public class BooksActivity extends AppCompatActivity implements BaseAdapter.OnItemClickListener<Book>,BooksView {

    private AQuery mAq;
    private BooksPresenter mPresenter;
    private LoadingView mLoadingView;
    private BooksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        mAq = new AQuery(this);
        setSupportActionBar((Toolbar) mAq.id(R.id.toolbar).getView());

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        EmptyRecyclerView recyclerView = (EmptyRecyclerView) mAq.id(R.id.recyclerView).getView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setEmptyView(mAq.id(R.id.empty).getView());

        mAdapter = new BooksAdapter(new ArrayList<>());
        mAdapter.attachToRecyclerView(recyclerView);
        mAdapter.setOnItemClickListener(this);

        LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new BooksPresenter(lifecycleHandler, this);
        mPresenter.init();
    }


    @Override
    public void onItemClick(@NonNull Book item) {
        mPresenter.onItemClick(item);
    }

    @Override
    public void showLoading() {
        mLoadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

    @Override
    public void showError() {
        mAdapter.clear();
    }

    @Override
    public void showCharacters(Book book) {
        CharactersActivity.start(this, book);
//        CharacterActivity.start(this, new Character());
    }

    @Override
    public void showBooks(List<Book> books) {
        mAdapter.changeDataSet(books);
    }
}
