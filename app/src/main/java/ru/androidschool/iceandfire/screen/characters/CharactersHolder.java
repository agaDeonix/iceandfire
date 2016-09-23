package ru.androidschool.iceandfire.screen.characters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import ru.androidschool.iceandfire.content.Character;
import com.androidquery.AQuery;

import java.util.List;

import ru.androidschool.iceandfire.R;
import ru.androidschool.iceandfire.content.RealmString;

/**
 * @author Azat Galiullin
 */

public class CharactersHolder extends RecyclerView.ViewHolder{

    private AQuery mAq;

    public CharactersHolder(View itemView) {
        super(itemView);
        mAq=new AQuery(itemView);
    }

    public void bind(@NonNull Character character){
        mAq.id(R.id.character_name).text(character.getName());
    }

}
