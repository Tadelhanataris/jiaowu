package com.example.ataris.jiaowu;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import utils.Http;
import utils.jsonhelper;

public class Notice extends Fragment {

    public static final Notice instance = new Notice();
    private ViewPager banner;
    private List<ImageView> images;
    private int currentItem;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View i = inflater.inflate(R.layout.activity_notice,container,false);
        banner = (ViewPager)i.findViewById(R.id.banner);
            Http.httpGet(Http.notice);
        images = new ArrayList<>();

        return i;
    }



    private class ViewPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(View container, int position) {
            //container.addView(images.get(position));
            return images.get(position);
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(images.get(position));
        }
    }

    private class ViewPageTask implements Runnable{
        @Override
        public void run() {
            currentItem = (currentItem + 1) % 5;
            mHandler.sendEmptyMessage(1245);
        }
    }

    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            if(msg.what==1245) {
                banner.setCurrentItem(currentItem);
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

    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),5, 5,
                TimeUnit.SECONDS);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }
}
