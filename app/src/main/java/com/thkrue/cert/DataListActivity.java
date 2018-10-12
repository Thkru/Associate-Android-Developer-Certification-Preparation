package com.thkrue.cert;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thkrue.cert.room.MyEntity;
import com.thkrue.cert.room.MyEntityViewModel;

import java.util.List;
import java.util.UUID;

public class DataListActivity extends AppCompatActivity {

    private MyEntityViewModel myEntityVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        myEntityVM = ViewModelProviders.of(this).get(MyEntityViewModel.class);

        RecyclerView recycler = findViewById(R.id.rv_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);
        final MyListAdapter adapter = new MyListAdapter();
        recycler.setAdapter(adapter);
        setupViewModel(adapter);
        initFab();
    }

    private void initFab() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEntityVM.insert(new MyEntity(UUID.randomUUID().toString().substring(0, 8)));
            }
        });
    }

    private void setupViewModel(final MyListAdapter adapter) {
        myEntityVM.getAllEntities().observe(this, new Observer<List<MyEntity>>() {
            @Override
            public void onChanged(@Nullable final List<MyEntity> entities) {
                adapter.setData(entities);
            }
        });
    }
}