package com.seuic.sell.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class ModifySignActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_modifyitem;
    private ImageView iv_left,iv_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_sign);
        initView();
    }

    private void initView(){
        et_modifyitem = (EditText)findViewById(R.id.et_modifyitem);

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
                finish();
                break;
        }
    }
}
