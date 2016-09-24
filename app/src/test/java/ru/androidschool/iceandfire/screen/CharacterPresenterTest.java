package ru.androidschool.iceandfire.screen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.screen.characters.CharactersPresenter;
import ru.androidschool.iceandfire.screen.characters.CharactersView;
import ru.androidschool.iceandfire.test.MockLifecycleHandler;
import ru.arturvasilov.rxloader.LifecycleHandler;

/**
 * @author Azat Galiullin
 */

public class CharacterPresenterTest {

    private CharactersView mCharacterView;
    private CharactersPresenter mCharacterPresenter;

    @Before
    public void setUp() throws Exception {
        LifecycleHandler lifecycleHandler=new MockLifecycleHandler();
        mCharacterView= Mockito.mock(CharactersView.class);

        mCharacterPresenter=new CharactersPresenter(lifecycleHandler,mCharacterView);
    }

    @Test
    public void testCreated() throws Exception {
        Assert.assertNotNull(mCharacterPresenter);
    }
}
