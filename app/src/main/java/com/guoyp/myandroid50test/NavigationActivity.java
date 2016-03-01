package com.guoyp.myandroid50test;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by guoyp on 2016/2/26.
 */
public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button mButton;
    private NavigationView mNavigationView;//抽屉式菜单栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationview);
        init();
        setListener();
    }
    private void init(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawerlayout);
        mButton = (Button) findViewById(R.id.navigation_button);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

    }
    private void setListener(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {//NavigationView item item监听事件
            private MenuItem pMenuItem;
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if(pMenuItem != null) pMenuItem.setChecked(false);
                item.setChecked(true);
                switch(id){
                    case R.id.item_navigation_one:
//                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(NavigationActivity.this,"navigation item money clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item_navigation_two:
                        Toast.makeText(NavigationActivity.this,"navigation item seach clicked", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                pMenuItem = item;
                return true;
            }
        });
    }
}
