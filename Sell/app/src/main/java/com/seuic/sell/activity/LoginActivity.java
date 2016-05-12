package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;


public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText et_email,et_password;
    private ImageView iv_left,iv_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        et_email = (EditText)findViewById(R.id.et_email);
        et_password = (EditText)findViewById(R.id.et_password);

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
                startActivity(new Intent(LoginActivity.this,SellMainActivity.class));
                break;
        }
    }

    private void login(){
        if(TextUtils.isEmpty(et_email.getText().toString().trim())){
            Toast.makeText(this,"请输入电子邮箱账号",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(et_password.getText().toString().trim())){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }


    }
}
