package ru.androidschool.iceandfire.screen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import ru.androidschool.iceandfire.content.Book;
import ru.androidschool.iceandfire.screen.books.BooksPresenter;
import ru.androidschool.iceandfire.screen.books.BooksView;
import ru.androidschool.iceandfire.test.MockLifecycleHandler;
import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * @author Azat Galiullin
 */
@RunWith(JUnit4.class)
public class BooksPresenterTest {

    private BooksView mBooksView;
    private BooksPresenter mBooksPresenter;

    @Before
    public void setUp() throws Exception {
        LifecycleHandler lifecycleHandler=new MockLifecycleHandler();
        mBooksView= Mockito.mock(BooksView.class);

        mBooksPresenter=new BooksPresenter(lifecycleHandler,mBooksView);
    }

    @Test
    public void testCreated() throws Exception {
        Assert.assertNotNull(mBooksPresenter);
    }

    @Test
    public void testItemClick() throws Exception {
        Book book=new Book();
        mBooksPresenter.onItemClick(book);
        Mockito.verify(mBooksView).showCharacters(book);
    }
}
