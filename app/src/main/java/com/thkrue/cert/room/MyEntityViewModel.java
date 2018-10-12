package com.thkrue.cert.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

import java.util.List;

public class MyEntityViewModel extends AndroidViewModel {

    private MyEntityRepository mRepo;
    private LiveData<PagedList<MyEntity>> mAllEntities;

    public MyEntityViewModel(Application a) {
        super(a);
        mRepo = new MyEntityRepository(a.getApplicationContext());
        mAllEntities = mRepo.getData();
    }

    public LiveData<PagedList<MyEntity>> getAllEntities() {
        return mAllEntities;
    }

    public void insert(MyEntity entity) {
        mRepo.insert(entity);
    }
}