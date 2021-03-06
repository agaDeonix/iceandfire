package ru.androidschool.iceandfire.screen.character;

import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.screen.general.LoadingView;

/**
 * Created by deonix on 23/09/16.
 */

public interface CharacterView extends LoadingView {
    void showCharacter(Character character);

    void showError();
}
