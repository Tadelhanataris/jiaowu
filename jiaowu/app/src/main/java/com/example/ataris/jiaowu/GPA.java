package com.example.ataris.jiaowu;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import utils.Http;

public class GPA extends Fragment {
    public static final GPA instance = new GPA();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View i = inflater.inflate(R.layout.activity_gpa,container,false);
        return i;
    }
    public static double cal(int gpa)
    {
        return ((double)gpa-50)/10;
    }
}
