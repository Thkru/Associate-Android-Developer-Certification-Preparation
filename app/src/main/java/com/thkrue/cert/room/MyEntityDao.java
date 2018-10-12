package com.thkrue.cert.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@android.arch.persistence.room.Dao
public interface MyEntityDao {

    @Insert()
    void insert(MyEntity... entities);

//    @Query("Select * FROM alphabet")
//    MyEntity[] getEntities();

//    @Query("Select * FROM alphabet where alphabetindex = :alphabetindex LIMIT :limit")
//    MyEntity[] getEntities(int alphabetindex, int limit);

    @Query("SELECT * FROM alphabet")
    LiveData<List<MyEntity>> getEntities();

}
