package com.thkrue.cert.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import java.util.List;

public class MyEntityViewModel extends ViewModel {

    private MyEntityRepository mRepo;
    private LiveData<List<MyEntity>> mAllEntities;

    public MyEntityViewModel(Context c) {
        mRepo = new MyEntityRepository(c);
        mAllEntities = mRepo.getData();
    }

    public LiveData<List<MyEntity>> getAllEntities() {
        return mAllEntities;
    }

    public void insert(MyEntity entity) {
        mRepo.insert(entity);
    }
}