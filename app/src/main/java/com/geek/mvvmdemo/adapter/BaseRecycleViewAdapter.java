package com.geek.mvvmdemo.adapter;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chenMeng on 2017/8/1.
 */

public class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseRecycleViewAdapter.BindingHolder> {
    @SuppressLint("SupportAnnotationUsage")
    public @LayoutRes ObservableInt layoutId;

    private AdapterModule adapterModule;

    private LayoutInflater inflater;

    public BaseRecycleViewAdapter(int layoutId) {
        this.layoutId = new ObservableInt(layoutId);
    }

    public void setAdapterModule(AdapterModule<T> adapterModule) {
        if (this.adapterModule == adapterModule || adapterModule == null) {
            return;
        }
        this.adapterModule = adapterModule;
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId.get(), null, false);
        BindingHolder holder = new BindingHolder(binding,(SparseArray<View.OnClickListener>) adapterModule.listeners.get());
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        onBindBinding(holder.binding, adapterModule.bindPositionVaiableId.get(), position, false);
        onBindBinding(holder.binding, adapterModule.bindingVaiable.get(), adapterModule.list.get(position), true);
    }

    private void onBindBinding(ViewDataBinding binding, int bindingVariable, Object item, boolean executePendingBindings) {
        if (bindingVariable != 0) {
            boolean result = binding.setVariable(bindingVariable, item);

            if (!result) {
                throw new IllegalArgumentException("绑定id异常");
            }
            // refresh
            if (executePendingBindings) {
                binding.executePendingBindings();
            }
        }
    }

    @Override
    public int getItemCount() {
        if (this.adapterModule == null) {
            return 0;
        }
        return this.adapterModule.list.size();
    }

    public static class BindingHolder<T> extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;
        private SparseArray<View.OnClickListener> listeners;

        public BindingHolder(ViewDataBinding binding,SparseArray<View.OnClickListener> listeners) {
            super(binding.getRoot());
            this.binding = binding;
            this.listeners = listeners;
            onBindListeners();
        }

        public void onBindListeners() {
            if (listeners != null && listeners.size() > 0) {
                for (int i = 0; i < listeners.size(); i++) {
                    binding.setVariable(listeners.keyAt(i), listeners.get(listeners.keyAt(i)));
                }
            }
        }
    }

}
