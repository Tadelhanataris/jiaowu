package com.example.ataris.jiaowu;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.jsonhelper;

public class Review extends Fragment {

    public static final Review instance = new Review();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_review, container, false);
    }


    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            if(msg.what==1245) {
//                banner.setCurrentItem(currentItem);
            }else if(msg.what==2564 && msg.arg1==0){
                JSONArray datas = jsonhelper.arrayParse((byte[])msg.obj);
                try {
                    for(int i=0;i<datas.length();i++)
                    {
                        JSONObject a = datas.getJSONObject(i);
                        a.getString("title");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                super.handleMessage(msg);
            }
        }
    };
}
