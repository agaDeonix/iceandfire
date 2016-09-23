package ru.androidschool.iceandfire.screen.character;

import android.support.annotation.NonNull;

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

    public void init() {

    }
}
