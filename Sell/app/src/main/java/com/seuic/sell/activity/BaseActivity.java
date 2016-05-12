package com.seuic.sell.activity;

import android.app.Activity;
import android.os.Bundle;

import com.seuic.sell.MyApplication;

/**
 * Created by Administrator on 2016/5/9.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加Activity到堆栈
        MyApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束Activity&从栈中移除该Activity
        MyApplication.getInstance().finishActivity(this);
    }

}
