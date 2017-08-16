package com.geek.mvvmdemo.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.util.SparseArray;
import android.view.View.OnClickListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by chenMeng on 2017/8/1.
 */

public class AdapterModule<T> {
    public ObservableArrayList<T> list = new ObservableArrayList<>();
    // 绑定的 T 实体类 BR
    public ObservableInt bindingVaiable;
    // bind Position   BR
    public ObservableInt bindPositionVaiableId;
    //onclick  BR
    public WeakReference<SparseArray<OnClickListener>> listeners;

    public AdapterModule(ArrayList<T> list, int bindingVaiable, int bindPositionVaiableId) {
        if (list != null && !list.isEmpty()) {
            this.list.addAll(list);
        }
        this.bindingVaiable = new ObservableInt(bindingVaiable);
        this.bindPositionVaiableId = new ObservableInt(bindPositionVaiableId);
    }

    public void setListeners(SparseArray<OnClickListener> listeners) {
        this.listeners = new WeakReference<>(listeners);
    }

}
