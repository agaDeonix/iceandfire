package ru.androidschool.iceandfire.screen.books;

import android.support.annotation.NonNull;

import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * Created by deonix on 21/09/16.
 */

public class BooksPresenter {
    private final LifecycleHandler mLifecycleHandler;
    private final BooksView mView;

    public BooksPresenter(@NonNull LifecycleHandler lifecycleHandler,
                                 @NonNull BooksView view) {
        mLifecycleHandler = lifecycleHandler;
        mView = view;
    }

    public void init() {
//        RepositoryProvider.provideGithubRepository()
//                .repositories()
//                .doOnSubscribe(mView::showLoading)
//                .doOnTerminate(mView::hideLoading)
//                .compose(mLifecycleHandler.load(R.id.repositories_request))
//                .subscribe(mView::showRepositories, throwable -> mView.showError());
    }

//    public void onItemClick(@NonNull Repository repository) {
//        mView.showCommits(repository);
//    }
}
