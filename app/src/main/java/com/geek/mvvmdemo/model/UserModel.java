package com.geek.mvvmdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by chenMeng on 2017/8/14.
 */

public class UserModel extends BaseObservable {
    @Bindable
    private String userName;
    @Bindable
    private String userAge;
    @Bindable
    private String userSex;
    @Bindable
    private String select;//0 选中  1没有选中

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
        notifyPropertyChanged(BR.select);
    }
}
