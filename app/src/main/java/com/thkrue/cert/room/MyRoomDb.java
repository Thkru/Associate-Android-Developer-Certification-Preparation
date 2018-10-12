package com.thkrue.cert.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class MyRoomDb extends RoomDatabase {

    public abstract MyEntityDao entityDao();

}