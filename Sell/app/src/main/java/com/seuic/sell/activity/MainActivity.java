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


public class MainActivity extends Activity implements View.OnClickListener{
    private TextView tv_zhuce,tv_denglu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        tv_zhuce = (TextView)findViewById(R.id.tv_zhuce);
        tv_zhuce.setOnClickListener(this);

        tv_denglu = (TextView)findViewById(R.id.tv_denglu);
        tv_denglu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }

        switch (v.getId()){
            case R.id.tv_zhuce:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.tv_denglu:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}
