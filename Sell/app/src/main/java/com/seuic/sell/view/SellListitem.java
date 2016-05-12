package com.seuic.sell.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seuic.sell.R;
import com.seuic.sell.util.FastClick;

/**
 * Created by Administrator on 2016/5/6.
 */
public class SellListitem  extends LinearLayout implements View.OnClickListener {
    private ImageView iv_sellitem,iv_touxiang,iv_weizhi,iv_time,iv_liaotian;
    private TextView tv_sign,tv_address,tv_time;
    private Button bt_price;

    public SellListitem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.selllistitem, this);

        iv_sellitem = (ImageView) findViewById(R.id.iv_sellitem);

        bt_price = (Button) findViewById(R.id.bt_price);
        bt_price.setOnClickListener(this);

        tv_sign = (TextView)findViewById(R.id.tv_sign);
        tv_address = (TextView)findViewById(R.id.tv_sign);
        tv_time = (TextView)findViewById(R.id.tv_sign);

    }

    @Override
    public void onClick(View v) {
        if (FastClick.isFastClick()) {
            return;
        }
        switch (v.getId()){
            case R.id.bt_price:
                break;
        }

    }
}
