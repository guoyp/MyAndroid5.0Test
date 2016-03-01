package com.guoyp.myandroid50test;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.guoyp.myandroid50test.adapter.ViewpageAdapter;
import com.guoyp.myandroid50test.fragment.FragmentThree;
import com.guoyp.myandroid50test.fragment.MyFragment;
import com.guoyp.myandroid50test.fragment.MyFragmentTwo;

import java.util.ArrayList;

/**
 * Created by guoyp on 2016/2/24.
 */
public class SecondActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        setListener();

    }

    private void init(){
        myToolbar = (Toolbar) findViewById(R.id.myfirsttoolbar);
        myToolbar.setTitle("SecondActivity");//设置主标题
//        myToolbar.setSubtitle("hei");//设置副标题
//        myToolbar.setLogo(R.drawable.icon_one);//设置logo
//        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.tb_icon_actionbar_back);//左边按钮

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPage = (ViewPager) findViewById(R.id.sencont_view_page);
        FragmentManager fm = getSupportFragmentManager();
        MyFragment mf = new MyFragment();
        MyFragmentTwo mft = new MyFragmentTwo();
        FragmentThree ftv = new FragmentThree();

        ArrayList<Fragment> list = new ArrayList<Fragment>();
        list.add(mf);
        list.add(mft);
        list.add(ftv);

        ViewpageAdapter adapter = new ViewpageAdapter(fm,list);
        mViewPage.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPage);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    private void setListener(){
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {//左边按钮监听事件
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Toolbar添加item
        getMenuInflater().inflate(R.menu.second_menu,menu);
        menu.add("item 0");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//Toolbar监听事件
        int id = item.getItemId();

        if(id == R.id.action_edit)
            Snackbar.make(myToolbar,"join card",Snackbar.LENGTH_LONG).show();

        if(id == R.id.action_settings){
            Snackbar.make(myToolbar,"add user",Snackbar.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSnackbar(View v,String msg){
        Snackbar.make(v,msg,Snackbar.LENGTH_LONG).show();
    }
}
