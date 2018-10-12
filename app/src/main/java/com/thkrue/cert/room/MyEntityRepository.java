package com.thkrue.cert.room;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class MyEntityRepository {

    private MyEntityDao mDao;
    private LiveData<List<MyEntity>> mLiveData;

    public MyEntityRepository(Context c) {
        mDao = MyRoomDb.getDatabase(c).entityDao();
        mLiveData = mDao.getEntities();
    }

    public LiveData<List<MyEntity>> getData() {
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
