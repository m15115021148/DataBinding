package com.geek.mvvmdemo.vm;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.geek.mvvmdemo.model.UserModel;

import java.util.List;

/**
 * Created by chenMeng on 2017/8/14.
 */

public class CommonVm extends BaseObservable{
    private Activity mContext;
    @Bindable
    private String title;
    @Bindable
    private String isSelect;
    private List<UserModel> list;

    public CommonVm(Activity activity, List<UserModel> list){
        this.mContext = activity;
        this.list = list;
    }

    public void onBack(){
        Toast.makeText(mContext,"主页面",Toast.LENGTH_SHORT).show();
    }

    public void select(){
        if (isSelect.equals("0")){
            setIsSelect("1");
            for (UserModel model:list){
                model.setSelect("1");
            }
        }else{
            setIsSelect("0");
            for (UserModel model:list){
                model.setSelect("0");
            }
        }
    }

    public String getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
        notifyPropertyChanged(BR.isSelect);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

}
