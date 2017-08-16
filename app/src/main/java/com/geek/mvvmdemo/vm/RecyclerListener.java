package com.geek.mvvmdemo.vm;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.geek.mvvmdemo.adapter.AdapterModule;
import com.geek.mvvmdemo.model.UserModel;

/**
 * Created by chenMeng on 2017/8/14.
 */

public class RecyclerListener implements View.OnClickListener {
    private Context mContext;
    private AdapterModule<UserModel> adapterModule;
    private CommonVm commonVm;



    public void onSelect(int position) {
        UserModel model = adapterModule.list.get(position);
        if (model.getSelect().equals("0")) {
            model.setSelect("1");
            commonVm.setIsSelect("1");
        } else {
            model.setSelect("0");
            int sum = 0;
            for (UserModel m : adapterModule.list) {
                if (m.getSelect().equals("0")) {
                    sum += 1;
                }
            }
            if (sum == adapterModule.list.size()) {
                commonVm.setIsSelect("0");
            }
        }
    }

    @Override
    public void onClick(View v) {
    }

    public AdapterModule<UserModel> getAdapterModule() {
        return adapterModule;
    }

    public void setAdapterModule(AdapterModule<UserModel> adapterModule) {
        this.adapterModule = adapterModule;
    }

    public CommonVm getCommonVm() {
        return commonVm;
    }

    public void setCommonVm(CommonVm commonVm) {
        this.commonVm = commonVm;
    }

    public RecyclerListener(Context context) {
        this.mContext = context;
    }

}
