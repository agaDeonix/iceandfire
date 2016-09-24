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

public class CharactersPresenterTest {

    private CharactersView mCharacterView;
    private CharactersPresenter mCharactersPresenter;

    @Before
    public void setUp() throws Exception {
        LifecycleHandler lifecycleHandler=new MockLifecycleHandler();
        mCharacterView= Mockito.mock(CharactersView.class);

        mCharactersPresenter=new CharactersPresenter(lifecycleHandler,mCharacterView);
    }

    @Test
    public void testCreated() throws Exception {
        Assert.assertNotNull(mCharactersPresenter);
    }

    @Test
    public void testItemClick() throws Exception {
        Character character=new Character();
        mCharactersPresenter.onItemClick(character);
        Mockito.verify(mCharacterView).showCharacter(character);
    }
}
