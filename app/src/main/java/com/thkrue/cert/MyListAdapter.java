package com.thkrue.cert;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thkrue.cert.room.MyEntity;

public class MyListAdapter extends PagedListAdapter<MyEntity, MyListAdapter.MyViewHolder> {

    protected MyListAdapter(@NonNull DiffUtil.ItemCallback<MyEntity> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        MyEntity item = getItem(pos);
        if (item != null)
            holder.bindData(item.toString());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tv_list_item);
        }

        public void bindData(String text) {
            textView.setText(text);
        }
    }
}
