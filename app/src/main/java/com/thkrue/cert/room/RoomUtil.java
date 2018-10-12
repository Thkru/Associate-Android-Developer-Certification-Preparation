package com.thkrue.cert.room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class RoomUtil {

    private static RoomUtil instance;
    private MyRoomDb db;

    public static RoomUtil getInstance(Context c) {
        if (instance == null)
            instance = new RoomUtil(c);
        return instance;
    }

    private RoomUtil(Context c) {
        db = Room.databaseBuilder(c.getApplicationContext(), MyRoomDb.class, "Sample.db").build();
        startRoom();
    }

    private void startRoom() {
        if (db.entityDao().getEntities().length == 0)
            fillDb();
    }

    private void fillDb() {
        int i = 0;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            i++;
            db.entityDao().insert(new MyEntity(String.valueOf(alphabet), i));
        }
    }

    public MyEntity[] getEntities() {
        return db.entityDao().getEntities();
    }

}
