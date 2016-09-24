package ru.androidschool.iceandfire.screen.character;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.androidquery.AQuery;

import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.content.RealmString;
import ru.androidschool.iceandfire.repository.DefaultBookRepository;
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
    private LifecycleHandler lifecycleHandler;
    private Character character;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        mAq = new AQuery(this);
        Toolbar toolbar = (Toolbar) mAq.id(R.id.toolbar).getView();
        setSupportActionBar(toolbar);
        mAq.id(R.id.toolbar_title).text(R.string.character_title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> finish());
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new CharacterPresenter(lifecycleHandler, this);
        mPresenter.init(getIntent().getStringExtra(CHARACTER_ID_KEY));
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

    @Override
    public void showCharacter(Character character) {
        this.character = character;
        if ("Male".equals(character.getGender())){
            mAq.id(R.id.gender).image(R.drawable.ic_man);
        } else if ("Female".equals(character.getGender())){
            mAq.id(R.id.gender).image(R.drawable.ic_woman);
        }
        mAq.id(R.id.name).text(character.getName());

        String aliases = "";
        for(RealmString alias: character.getAliases()){
            aliases += "\n" + alias.value;
        }
        mAq.id(R.id.aliases).text(aliases.substring(1));

        new DefaultBookRepository().getBooks()
                .compose(lifecycleHandler.load(R.id.books_request))
                .subscribe(this::showBooks, throwable -> this.showError());

        String seasons = "";
        for(RealmString season: character.getTvSeries()){
            seasons += "\n" + season.value;
        }
        mAq.id(R.id.seasons).text(seasons.substring(1));

        String actors = "";
        for(RealmString actor: character.getPlayedBy()){
            actors += "\n" + actor.value;
        }
        mAq.id(R.id.actors).text(actors.substring(1));

    }

    public void showError() {
        Toast.makeText(this, "Character error", Toast.LENGTH_SHORT).show();
    }

    public void showBooks(List<Book> books){
        String booksName = "";
        for(RealmString bookUrl: character.getBooks()){
            for (Book book: books){
                if (Book.getIdFromUrl(bookUrl.value) == Book.getIdFromUrl(book.getUrl())){
                    booksName += "\n" + book.getName();
                    break;
                }
            }
        }
        mAq.id(R.id.books).text(booksName.substring(1));
    }
}
