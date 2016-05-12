package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;


public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_name,et_address,et_sign,et_email,et_phone,et_password,et_comfirmpass;
    private ImageView iv_left,iv_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView(){
        et_name = (EditText)findViewById(R.id.et_name);
        et_address = (EditText)findViewById(R.id.et_address);
        et_sign = (EditText)findViewById(R.id.et_sign);
        et_email = (EditText)findViewById(R.id.et_email);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_password = (EditText)findViewById(R.id.et_password);
        et_comfirmpass = (EditText)findViewById(R.id.et_comfirmpass);

        iv_left = (ImageView)findViewById(R.id.iv_left);
        iv_left.setOnClickListener(this);

        iv_right = (ImageView)findViewById(R.id.iv_right);
        iv_right.setOnClickListener(this);
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
            case R.id.iv_right:
                startActivity(new Intent(this,SucceedRegisterActivity.class));
                finish();
                break;
        }
    }
}
