package com.thkrue.cert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        RecyclerView recycler = findViewById(R.id.rv_list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("Entry: " + i);
        }
        recycler.setAdapter(new ListAdapter(list));
    }
}
