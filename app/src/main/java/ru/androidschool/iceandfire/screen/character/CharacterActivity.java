package ru.androidschool.iceandfire.screen.character;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidquery.AQuery;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.screen.general.LoadingDialog;
import ru.androidschool.iceandfire.screen.general.LoadingView;
import ru.arturvasilov.rxloader.LifecycleHandler;
import ru.arturvasilov.rxloader.LoaderLifecycleHandler;

/**
 * Created by deonix on 23/09/16.
 */

public class CharacterActivity extends AppCompatActivity implements CharacterView {

    private static final String CHARACTER_ID_KEY = "CHARACTER_ID_KEY";

    private AQuery mAq;
    private CharacterPresenter mPresenter;
    private LoadingView mLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        mAq = new AQuery(this);
        Toolbar toolbar = (Toolbar) mAq.id(R.id.toolbar).getView();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new CharacterPresenter(lifecycleHandler, this);
        mPresenter.init();
    }

    public static void start(Activity activity, Character character){
        Intent intent = new Intent(activity, CharacterActivity.class);
        intent.putExtra(CHARACTER_ID_KEY, character.getUrl());
        activity.startActivity(intent);
    }

    @Override
    public void showLoading() {
        mLoadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

}
