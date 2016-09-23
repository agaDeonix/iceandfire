package ru.androidschool.iceandfire.screen.characters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.Character;
import ru.androidschool.iceandfire.widget.BaseAdapter;

/**
 * @author Azat Galiullin
 */

public class CharactersAdapter extends BaseAdapter<CharactersHolder,Character> {


    public CharactersAdapter(@NonNull List<Character> items) {
        super(items);
    }

    @Override
    public CharactersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CharactersHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character,parent,false));
    }

    @Override
    public void onBindViewHolder(CharactersHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Character character=getItem(position);
        holder.bind(character);
    }
}
