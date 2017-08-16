package com.geek.mvvmdemo.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geek.mvvmdemo.adapter.AdapterModule;
import com.geek.mvvmdemo.adapter.BaseRecycleViewAdapter;


/**
 * Created by chenMeng on 2017/8/1.
 */

public class BindingAdapterUtil {

    @BindingAdapter({"layoutId"})
    public static void bindRecycleViewLayoutId(RecyclerView recyclerView, int layoutId) {
        BaseRecycleViewAdapter baseRecycleViewAdapter = new BaseRecycleViewAdapter(layoutId);
        recyclerView.setAdapter(baseRecycleViewAdapter);
    }

    @BindingAdapter({"listData"})
    public static <T> void bindRecycleViewAdapterModule(RecyclerView recyclerView, AdapterModule<T> adapterModule) {
        BaseRecycleViewAdapter<T> adapter;
        if (recyclerView.getAdapter() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            adapter = (BaseRecycleViewAdapter<T>) recyclerView.getAdapter();
            adapter.setAdapterModule(adapterModule);
        } else {
            return;
        }
    }
}
