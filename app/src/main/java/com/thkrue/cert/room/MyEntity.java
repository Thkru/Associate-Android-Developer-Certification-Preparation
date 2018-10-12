package com.thkrue.cert.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "alphabet")
public class MyEntity {

    @PrimaryKey
    @ColumnInfo(name = "character")
    @NonNull
    private String character;

    @ColumnInfo(name = "alphabetindex")
    private int alphabetindex;


    public MyEntity(String character, int alphabetindex) {
        this.character = character;
        this.alphabetindex = alphabetindex;
    }

    public String getCharacter() {
        return character;
    }

    public int getAlphabetindex() {
        return alphabetindex;
    }

    @Override
    public String toString() {
        return character + " at " + alphabetindex;
    }
}
