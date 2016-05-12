package com.seuic.sell.Image;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/10.
 */
public interface OnImageDownload {
    void onDownloadSucc(Bitmap bitmap,String c_url,ImageView imageView);
}
