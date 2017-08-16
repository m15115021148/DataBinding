package com.geek.mvvmdemo.vm;

import android.app.Activity;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.geek.mvvmdemo.adapter.AdapterModule;
import com.geek.mvvmdemo.model.UserModel;

/**
 * Created by chenMeng on 2017/8/14.
 */

public class UserVm {
    private ObservableField<AdapterModule<UserModel>> mBinding;
    private AdapterModule<UserModel> adapterModule;
    private Activity mContext;

    public UserVm(Activity context,AdapterModule<UserModel> model){
        this.mContext = context;
        this.adapterModule = model;
        mBinding = new ObservableField<>();
        mBinding.set(model);
    }

    public void onClick(int position){
        Toast.makeText(mContext,"点击"+position,Toast.LENGTH_SHORT).show();
    }

    public AdapterModule<UserModel> getAdapterModule() {
        return adapterModule;
    }

    public void setAdapterModule(AdapterModule<UserModel> adapterModule) {
        this.adapterModule = adapterModule;
    }
}
