package com.thkrue.cert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thkrue.cert.room.MyEntity;
import com.thkrue.cert.room.RoomUtil;

public class DataListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        RecyclerView recycler = findViewById(R.id.rv_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        doWork(recycler);
    }

    public void doWork(final RecyclerView recyclerView) {

        new Thread() {
            @Override
            public void run() {

                final MyEntity[] data = RoomUtil.getInstance(DataListActivity.this).getEntities();

                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(new ListAdapter(data));
                    }
                });
            }
        }.start();
    }
}