package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.seuic.sell.R;


public class SucceedRegisterActivity extends BaseActivity {

    Handler handler=new Handler();

    Runnable runnable=new Runnable(){
        @Override
        public void run() {
           startActivity(new Intent(SucceedRegisterActivity.this,LoginActivity.class));
           finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succeed_register);
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK||keyCode == event.KEYCODE_HOME){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
