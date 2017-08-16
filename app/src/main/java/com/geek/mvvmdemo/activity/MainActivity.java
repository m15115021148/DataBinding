package com.geek.mvvmdemo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.geek.mvvmdemo.BR;
import com.geek.mvvmdemo.R;
import com.geek.mvvmdemo.adapter.AdapterModule;
import com.geek.mvvmdemo.databinding.ActivityMainBinding;
import com.geek.mvvmdemo.model.UserModel;
import com.geek.mvvmdemo.vm.CommonVm;
import com.geek.mvvmdemo.vm.RecyclerListener;
import com.geek.mvvmdemo.vm.UserVm;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //数据
        ArrayList<UserModel> list = new ArrayList<>();
        for (int i=0;i<6;i++){
            UserModel model = new UserModel();
            model.setSelect("1");
            model.setUserName("BINDING:"+i);
            model.setUserAge(String.valueOf(20+i));
            model.setUserSex("男");
            list.add(model);
        }

        //include数据
        CommonVm vm = new CommonVm(this,list);
        vm.setIsSelect("1");//1未选中   0 选中
        vm.setTitle("首页");

        //item点击事件
        SparseArray<View.OnClickListener> listener = new SparseArray<>();
        RecyclerListener l = new RecyclerListener(this);
        listener.put(BR.item,l);
        l.setCommonVm(vm);

        AdapterModule<UserModel> userModel = new AdapterModule<>(list, BR.user,BR.position);
        l.setAdapterModule(userModel);
        //绑定item点击事件
        userModel.setListeners(listener);

        UserVm userVm = new UserVm(this,userModel);

        mBinding.setLayoutId(R.layout.recylcer_view_item);
        mBinding.setUser(userVm);
        mBinding.setCommon(vm);
    }
}
