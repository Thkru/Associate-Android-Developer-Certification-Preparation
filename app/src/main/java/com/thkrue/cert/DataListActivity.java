package com.thkrue.cert;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thkrue.cert.room.MyEntity;
import com.thkrue.cert.room.MyEntityViewModel;

import java.util.List;

public class DataListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        RecyclerView recycler = findViewById(R.id.rv_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);
        final MyListAdapter adapter = new MyListAdapter();
        recycler.setAdapter(adapter);
        setupViewModel(adapter);
    }

    private void setupViewModel(final MyListAdapter adapter) {
        MyEntityViewModel myEntityVM = new MyEntityViewModel(this.getApplicationContext());
        myEntityVM.getAllEntities().observe(this, new Observer<List<MyEntity>>() {
            @Override
            public void onChanged(@Nullable final List<MyEntity> entities) {
                adapter.setData(entities);
            }
        });
    }

//    public void doWork(final RecyclerView recyclerView) {
//
//        new Thread() {
//            @Override
//            public void run() {
//
//                final MyEntity[] data = MyEntityRepository.getInstance(DataListActivity.this).getEntities();
//
//                recyclerView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        recyclerView.setAdapter(new MyListAdapter(data));
//                    }
//                });
//            }
//        }.start();
//    }
}