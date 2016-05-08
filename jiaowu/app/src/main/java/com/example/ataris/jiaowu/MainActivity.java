package com.example.ataris.jiaowu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Notice noticepage = Notice.instance;
    private project projectpage = project.instance;
    private Review reviewpage = Review.instance;
    private Schedule schedulepage = Schedule.instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        noticepage = new Notice();
        transaction.replace(R.id.content, noticepage);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        int id = item.getItemId();

        switch (id)
        {
            case R.id.notice:
                //进入通知页面
                if (noticepage == null)
                {
                    noticepage = new Notice();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.content, noticepage);
                break;
            case R.id.schedule:
                //进入课程表页面
                if (schedulepage == null)
                {
                    schedulepage = new Schedule();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.content, schedulepage);
                break;
            case R.id.GPA:
                //进入绩点计算页面
                break;
            case R.id.chose_class:
                //进入选课页面
                break;
            case R.id.project:
                //进入毕业设计页面
                break;
            case R.id.share:
                //进入资源共享页面
                break;
            case R.id.review:
                //进入教学评价页面
                break;
            case R.id.bbs:
                //进入论坛页面
                break;

        }
//        if (id == R.id.notice) {
//            //进入通知页面
//        } else if (id == R.id.schedule) {
//            //进入课程表页面
//
//        } else if (id == R.id.GPA) {
//            //进入绩点计算页面
//
//        } else if (id == R.id.chose_class) {
//            //进入选课页面
//
//        } else if (id == R.id.project) {
//            //进入毕业设计页面
//
//        } else if (id == R.id.share) {
//            //进入资源共享页面
//
//        } else if (id == R.id.review) {
//            //进入教学评价页面
//
//        } else if (id == R.id.bbs) {
//            //进入论坛页面
//
//        }

        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
