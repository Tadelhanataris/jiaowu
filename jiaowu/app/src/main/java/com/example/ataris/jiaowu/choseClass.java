package com.example.ataris.jiaowu;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class choseClass extends Fragment {
    public static final choseClass instance = new choseClass();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View i = inflater.inflate(R.layout.activity_chose_class,container,false);
        return i;
    }
}
