package com.thkrue.cert.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

public class MyEntityViewModel extends AndroidViewModel {

    private MyEntityRepository mRepo;

    public MyEntityViewModel(Application a) {
        super(a);
        mRepo = new MyEntityRepository(a.getApplicationContext());
    }

    public LiveData<PagedList<MyEntity>> getAllEntities() {
        return mRepo.getData();
    }

    public void insert(MyEntity entity) {
        mRepo.insert(entity);
    }
}