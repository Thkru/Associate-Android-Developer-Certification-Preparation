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


    public MyEntity(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return character;
    }
}
