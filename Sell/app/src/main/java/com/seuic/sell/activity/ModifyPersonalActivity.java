package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class ModifyPersonalActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_modifyName,tv_address,tv_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_personal);
        initView();
    }

    private void initView(){
        tv_modifyName = (TextView)findViewById(R.id.tv_modifyName);
        tv_modifyName.setOnClickListener(this);
        tv_address = (TextView)findViewById(R.id.tv_address);
        tv_address.setOnClickListener(this);
        tv_sign = (TextView)findViewById(R.id.tv_sign);
        tv_sign.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }
        switch (v.getId()){
            case R.id.tv_modifyName:
                startActivity(new Intent(this,ModifyNameActivity.class));
                break;
            case R.id.tv_address:
                startActivity(new Intent(this,ModifyAddressActivity.class));
                break;
            case R.id.tv_sign:
                startActivity(new Intent(this,ModifySignActivity.class));
                break;
        }

    }
}
