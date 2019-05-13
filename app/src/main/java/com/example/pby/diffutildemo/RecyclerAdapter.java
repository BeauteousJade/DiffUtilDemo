package com.example.pby.diffutildemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<Bean> mDataList;

    public RecyclerAdapter(List<Bean> list) {
        this.mDataList = list;
    }


    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (!payloads.isEmpty() && payloads.contains("content")) {
            holder.mTextView.setText(mDataList.get(position).getContent());
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder viewHolder, int i) {
        viewHolder.itemView.setBackgroundColor(mDataList.get(i).getColor());
        viewHolder.mTextView.setText(mDataList.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
}
