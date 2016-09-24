package ru.androidschool.iceandfire.screen.character;

import android.support.annotation.NonNull;
import android.util.Log;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.repository.DefaultBookRepository;
import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * Created by deonix on 23/09/16.
 */

public class CharacterPresenter {

    private final LifecycleHandler mLifecycleHandler;
    private final CharacterView mView;

    public CharacterPresenter(@NonNull LifecycleHandler lifecycleHandler,
                              @NonNull CharacterView view) {
        mLifecycleHandler = lifecycleHandler;
        mView = view;
    }

    public void init(String characterUrl) {
        new DefaultBookRepository().getCharacter(Character.getIdFromUrl(characterUrl))
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .compose(mLifecycleHandler.load(R.id.character_request))
                .subscribe(mView::showCharacter,throwable -> {
                    Log.d("Error",throwable.getMessage());
                    mView.showError();
                });
//        mView.showCharacter(Character.createTest());
    }
}
