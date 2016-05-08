package com.example.ataris.jiaowu;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class project extends Fragment {
private ListView project123;
    private List<String> data;
    public static final project instance = new project();
    LayoutInflater _inflater;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        _inflater=inflater;
        View i = inflater.inflate(R.layout.activity_project, container, false);

        project123 = (ListView) i.findViewById(R.id.project_list);
        XuantiAdapter adpter = new XuantiAdapter(getActivity(),R.layout.project_item_layout);
        project123.setAdapter((ListAdapter) adpter);





        return i;
    }


    private class XuantiAdapter extends ArrayAdapter<Xuanti>{
        private int mResourceId;

        public XuantiAdapter(Context context, int textViewResourceId) {
           super(context, textViewResourceId);
            this.mResourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Xuanti xuanti = getItem(position);
            View view = _inflater.inflate(mResourceId, null);
            TextView nameText = (TextView) view.findViewById(R.id.project_name);
            TextView teacherText = (TextView) view.findViewById(R.id.project_teacher);
            TextView typeText = (TextView) view.findViewById(R.id.project_type);

            nameText.setText(xuanti.getProject_name());
            teacherText.setText(xuanti.getProject_teacher());
            typeText.setText(xuanti.getProject_type());

            return view;
        }

    }
    private class Xuanti {
        private String project_teacher;
        private String project_name;
        private String project_type;

        public Xuanti(String project_name,String project_teacher,String project_type){
            this.project_name = project_name;
            this.project_teacher=project_teacher;
            this.project_type=project_type;
        }

        public String getProject_name() {
            return project_name;
        }

        public String getProject_type() {
            return project_type;
        }

        public String getProject_teacher() {
            return project_teacher;
        }
    }
}




