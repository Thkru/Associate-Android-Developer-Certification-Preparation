package com.thkrue.cert.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class MyRoomDb extends RoomDatabase {

    public abstract MyEntityDao entityDao();

    private static MyRoomDb INSTANCE;

    static MyRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDb.class, "Sample.db")//TODO fill database again
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

//    private static void fillDb() {
//        int i = 0;
//        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
//            i++;
//            db.entityDao().insert(new MyEntity(String.valueOf(alphabet), i));
//        }
//    }
}