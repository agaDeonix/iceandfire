package ru.androidschool.iceandfire.content;

import io.realm.RealmObject;

/**
 * Created by deonix on 21/09/16.
 */

public class RealmString extends RealmObject {
    public String value;

    public RealmString(String value) {
        this.value = value;
    }

    public RealmString() {
    }
}
