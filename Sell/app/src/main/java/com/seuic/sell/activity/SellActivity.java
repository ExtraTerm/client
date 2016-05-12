package com.seuic.sell.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;
import com.seuic.sell.view.MyRadioGroup;

public class SellActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_name,tv_phone,tv_showprice;
    private ImageView iv_zuoping,iv_left;
    private MyRadioGroup rg_pay;
    private RadioButton rb_baidu,rb_weixin,rb_zhifubao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        initView();
    }

    private void initView(){
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_phone = (TextView)findViewById(R.id.tv_phone);
        tv_showprice = (TextView)findViewById(R.id.tv_showprice);

        iv_zuoping = (ImageView)findViewById(R.id.iv_zuoping);
        iv_left = (ImageView)findViewById(R.id.iv_left);
        iv_left.setOnClickListener(this);


        rg_pay = (MyRadioGroup)findViewById(R.id.rg_pay);
        rg_pay.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {

            }
        });

        rb_baidu = (RadioButton)findViewById(R.id.rb_baidu);
        rb_weixin = (RadioButton)findViewById(R.id.rb_weixin);
        rb_zhifubao = (RadioButton)findViewById(R.id.rb_zhifubao);
    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }
        switch (v.getId()){
            case R.id.iv_left:
                finish();
                break;
        }
    }
}
