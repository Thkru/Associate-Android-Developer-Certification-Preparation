package com.thkrue.cert.room;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@android.arch.persistence.room.Dao
public interface MyEntityDao {

    @Insert()
    void insert(MyEntity... entities);

//    @Query("Select * FROM alphabet")
//    MyEntity[] getEntities();

//    @Query("Select * FROM alphabet where alphabetindex = :alphabetindex LIMIT :limit")
//    MyEntity[] getEntities(int alphabetindex, int limit);

    @Query("SELECT * FROM alphabet")
    DataSource.Factory<Integer, MyEntity> getEntities();
//    LiveData<PagedList<MyEntity>> getEntities();

}
