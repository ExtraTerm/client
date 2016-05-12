package com.seuic.sell.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

public class PersonalActivity extends BaseActivity {
    private TextView tv_name,tv_changzhu,tv_qianming;
    private ListView lv_maiitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
    }

    private void initView(){
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_changzhu = (TextView)findViewById(R.id.tv_changzhu);
        tv_qianming = (TextView)findViewById(R.id.tv_qianming);

        lv_maiitem = (ListView)findViewById(R.id.lv_maiitem);
        lv_maiitem.setAdapter(new MyAdapter(this));
    }


    public final class ViewHolder{
        public ImageView img1;
        public ImageView img2;
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
                convertView = mInflater.inflate(R.layout.personallistitem, null);
                holder.img1 = (ImageView)convertView.findViewById(R.id.iv_1);
                holder.img2 = (ImageView)convertView.findViewById(R.id.iv_2);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }

            return convertView;
        }

    }

}
