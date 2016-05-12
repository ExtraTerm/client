package com.seuic.sell.HttpService;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.seuic.sell.entity.User;
import com.seuic.sell.util.HttpClientUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ServiceImp {

    public boolean addUser(User mUser){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("user",JSON.toJSONString(mUser));
        map.put("method","addUser");
        String result = getHttpResponse(map,"12334");
        if(!TextUtils.isEmpty(result)&&result.equals("true")){
             return true;
        }else{
            return false;
        }
    }

    public boolean modifyName(User mUser){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("user",JSON.toJSONString(mUser));
        map.put("method","modifyName");
        String result = getHttpResponse(map,"12334");
        if(!TextUtils.isEmpty(result)&&result.equals("true")){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyAddress(User mUser){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("user",JSON.toJSONString(mUser));
        map.put("method","modifyAddress");
        String result = getHttpResponse(map,"12334");
        if(!TextUtils.isEmpty(result)&&result.equals("true")){
            return true;
        }else{
            return false;
        }
    }

    public boolean modifySign(User mUser){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("user",JSON.toJSONString(mUser));
        map.put("method","modifySign");
        String result = getHttpResponse(map,"12334");
        if(!TextUtils.isEmpty(result)&&result.equals("true")){
            return true;
        }else{
            return false;
        }
    }

    public User findUser(String email){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email",email);
        map.put("method","findUser");
        String result = getHttpResponse(map,"12334");
        if(!TextUtils.isEmpty(result)){
            return null;
        }else{
            return null;
        }
    }

    public String getHttpResponse(HashMap<String,String> param,String URL){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        String result=null;
        for(int i = 0;i<2;i++) {
            result = HttpClientUtils.requestResult(HttpClientUtils.POST_METHOD, URL,
                    null, params);
            if (result != null) {
                break;
            }
        }

        return result;
    }

}
