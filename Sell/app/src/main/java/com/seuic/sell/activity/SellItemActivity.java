package com.seuic.sell.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class SellItemActivity extends BaseActivity implements View.OnClickListener{
    private EditText et_describe,et_address,et_time,et_pirce;
    private ImageView iv_add;
    private Button bt_issuance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_item);
        initView();
    }

    private void initView(){
        et_describe = (EditText)findViewById(R.id.et_describe);
        et_address = (EditText)findViewById(R.id.et_address);
        et_time = (EditText)findViewById(R.id.et_time);
        et_pirce = (EditText)findViewById(R.id.et_pirce);

        iv_add = (ImageView)findViewById(R.id.iv_add);
        iv_add.setOnClickListener(this);

        bt_issuance = (Button)findViewById(R.id.bt_issuance);
        bt_issuance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }

        switch (v.getId()){
            case R.id.iv_add:
                break;
            case R.id.bt_issuance:
                break;
        }
    }
}
