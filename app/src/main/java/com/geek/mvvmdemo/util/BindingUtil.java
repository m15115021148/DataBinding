package com.geek.mvvmdemo.util;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geek.mvvmdemo.R;
import com.geek.mvvmdemo.databinding.IncludeTitleBinding;
import com.squareup.picasso.Picasso;

/**
 * Created by chenMeng on 2017/7/31.
 */

public class BindingUtil {

    /**
     * 第一个参数必须是view
     * @param imageView
     * @param isSelect
     */
    @BindingAdapter({"image"})
    public static void loadImage(ImageView imageView, String isSelect) {
        if (isSelect.equals("0")){
            imageView.setImageResource(R.drawable.na2ne_95);
        }else{
            imageView.setImageResource(R.drawable.na2ne_98);
        }
    }

    /**
     * 拼接
     * @param view
     * @param msg
     */
    @BindingAdapter({"text"})
    public static void showMsg(TextView view,String msg){
        view.setText(msg);
    }

}
