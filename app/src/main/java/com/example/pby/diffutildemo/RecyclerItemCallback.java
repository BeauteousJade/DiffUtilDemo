package com.example.pby.diffutildemo;


import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;
import java.util.Objects;

public class RecyclerItemCallback extends DiffUtil.Callback {

    private List<Bean> mOldDataList;
    private List<Bean> mNewDataList;

    public RecyclerItemCallback(List<Bean> oldDataList, List<Bean> newDataList) {
        this.mOldDataList = oldDataList;
        this.mNewDataList = newDataList;
    }

    @Override
    public int getOldListSize() {
        return mOldDataList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewDataList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return Objects.equals(mNewDataList.get(newItemPosition).getId(), mOldDataList.get(oldItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return Objects.equals(mOldDataList.get(i).getContent(), mNewDataList.get(i1).getContent());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Bean oldBean = mOldDataList.get(oldItemPosition);
        Bean newBean = mNewDataList.get(newItemPosition);
        if (!Objects.equals(oldBean.getContent(), newBean.getContent())) {
            return "content";
        }
        return null;
    }
}
