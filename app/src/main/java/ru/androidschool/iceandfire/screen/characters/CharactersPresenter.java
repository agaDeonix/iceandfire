package ru.androidschool.iceandfire.screen.characters;

import android.util.Log;

import ru.androidschool.iceandfire.BuildConfig;
import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.repository.DefaultBookRepository;
import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * @author Azat Galiullin
 */

public class CharactersPresenter {

    private final LifecycleHandler mHandler;
    private final CharactersView mView;

    public CharactersPresenter(LifecycleHandler lifecycleHandler, CharactersView charactersView) {
        mHandler=lifecycleHandler;
        mView=charactersView;
    }

    public void init(String bookUrl) {
        new DefaultBookRepository().getCharacters(Character.getIdFromUrl(bookUrl))
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .compose(mHandler.load(R.id.characters_request))
                .subscribe(mView::showCharacters,throwable -> {
                    Log.d("Error",throwable.getMessage());
                    mView.showError();
                });
    }

    public void onItemClick(Character item) {
        mView.showCharacter(item);
    }
}
