package com.seuic.sell.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seuic.sell.MyApplication;
import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class SettingActivity extends BaseActivity implements View.OnClickListener{
    private ImageView iv_touxiang;
    private TextView tv_name,tv_homepage,tv_order,tv_zan,tv_close;
    private RelativeLayout rl_modifypersonal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView(){
        iv_touxiang = (ImageView)findViewById(R.id.iv_touxiang);

        rl_modifypersonal = (RelativeLayout)findViewById(R.id.rl_modifypersonal);
        rl_modifypersonal.setOnClickListener(this);

        tv_name = (TextView)findViewById(R.id.tv_name);

        tv_homepage = (TextView)findViewById(R.id.tv_homepage);
        tv_homepage.setOnClickListener(this);
        tv_order = (TextView)findViewById(R.id.tv_order);
        tv_order.setOnClickListener(this);
        tv_zan = (TextView)findViewById(R.id.tv_zan);
        tv_zan.setOnClickListener(this);
        tv_close = (TextView)findViewById(R.id.tv_close);
        tv_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }
       switch (v.getId()){
           case R.id.rl_modifypersonal:
               startActivity(new Intent(this,ModifyPersonalActivity.class));
               break;
           case R.id.tv_homepage:
               startActivity(new Intent(this,PersonalActivity.class));
               break;
           case R.id.tv_order:
               startActivity(new Intent(this,OrdersActivity.class));
               break;
           case R.id.tv_zan:
               break;
           case R.id.tv_close:
               ((MyApplication)getApplication()).AppExit();
               break;
       }
    }
}
