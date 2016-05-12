package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class SellMainActivity extends BaseActivity implements View.OnClickListener{
    private ListView lv_sellitem;
    private ImageView iv_home,iv_liaotian,iv_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_main);
        initView();
    }

    private void initView(){
        lv_sellitem = (ListView)findViewById(R.id.lv_sellitem);
        lv_sellitem.setAdapter(new MyAdapter(this));
        iv_home = (ImageView)findViewById(R.id.iv_home);
        iv_home.setOnClickListener(this);

        iv_liaotian = (ImageView)findViewById(R.id.iv_liaotian);
        iv_liaotian.setOnClickListener(this);

        iv_set = (ImageView)findViewById(R.id.iv_set);
        iv_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(FastClick.isFastClick()){
            return;
        }
        switch (v.getId()){
            case R.id.iv_home:
                showPopupWindow(v);
                break;
            case R.id.iv_liaotian:
                startActivity(new Intent(this,MessageActivity.class));
                break;
            case R.id.iv_set:
                startActivity(new Intent(this,SettingActivity.class));
                break;
        }
    }
    PopupWindow popupWindow;
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.popupwindow, null);
        // 设置按钮的点击事件
        RelativeLayout button = (RelativeLayout) contentView.findViewById(R.id.rl_sell);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellMainActivity.this,SellItemActivity.class));
                popupWindow.dismiss();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        popupWindow= new PopupWindow(contentView,
                dm.widthPixels,200);

        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.color.blackTransparent5));

        int[] location = new int[2];
        view.getLocationOnScreen(location);

        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getHeight());

    }


    public final class ViewHolder{
        public ImageView img;
        public TextView sign;
        public TextView address;
        public TextView time;
        public Button priceBtn;
    }

    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 8;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.selllistitem, null);
                holder.img = (ImageView)convertView.findViewById(R.id.iv_sellitem);
                holder.sign = (TextView)convertView.findViewById(R.id.tv_sign);
                holder.address = (TextView)convertView.findViewById(R.id.tv_address);
                holder.time = (TextView)convertView.findViewById(R.id.tv_time);
                holder.priceBtn = (Button)convertView.findViewById(R.id.bt_price);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }



            holder.priceBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(FastClick.isFastClick()){
                        return;
                    }
                    startActivity(new Intent(SellMainActivity.this,SellActivity.class));
                }
            });
            return convertView;
        }

    }
}
