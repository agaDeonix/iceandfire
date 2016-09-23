package ru.androidschool.iceandfire.screen.characters;

import java.util.List;

import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.screen.general.LoadingView;

/**
 * @author Azat Galiullin
 */

public interface CharactersView extends LoadingView {

    void showError();

    void showCharacters(List<Character> characters);

    void showCharacter(Character character);

}
