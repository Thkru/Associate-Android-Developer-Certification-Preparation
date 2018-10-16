package com.thkrue.cert.room;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.content.Context;
import android.os.AsyncTask;

public class MyEntityRepository {

    public static final int PAGE_SIZE = 5;
    private MyEntityDao mDao;
    private LiveData<PagedList<MyEntity>> mLiveData;

    public MyEntityRepository(Context c) {
        mDao = MyRoomDb.getDatabase(c).entityDao();
        mLiveData = new LivePagedListBuilder<>(mDao.getEntities(), PAGE_SIZE).build();
    }

    public LiveData<PagedList<MyEntity>> getData() {
        return mLiveData;
    }

    public void insert(MyEntity entity) {
        new insertAsyncTask(mDao).execute(entity);
    }

    private static class insertAsyncTask extends AsyncTask<MyEntity, Void, Void> {

        private MyEntityDao mAsyncTaskDao;

        insertAsyncTask(MyEntityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final MyEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
