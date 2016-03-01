package com.guoyp.myandroid50test;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by guoyp on 2016/2/26.
 */
public class NavigationActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;//只能从手机屏幕的最边上滑动才能有效显示菜单栏
    private Button mButton;
    private NavigationView mNavigationView;//抽屉式菜单栏
    private GestureDetector mGestureDetector;//自定义向右滑动手势

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

        mGestureDetector = new GestureDetector(NavigationActivity.this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.i("TEST","e1 = " + e1.getRawX());
                Log.i("TEST","e2 = " + e2.getRawX());
                if (Math.abs(velocityX) < 100) {
                    Log.i("TEST","手指移动的太慢了");
                    return true;
                }
                if(e2.getRawX()-e1.getRawX()>200){//向右滑动手势
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                if(e1.getRawX()-e2.getRawX()>200){
                    Log.i("TEST","向左滑动手势");
                    return true;
                }
                if (Math.abs(velocityY) < 100) {
                    Log.i("TEST","手指移动的太慢了");
                    return true;
                }
                if ((e2.getRawY() - e1.getRawY()) > 200) {
                    Log.i("TEST","向下滑动手势");
                    return true;
                }
                if ((e1.getRawY() - e2.getRawY()) > 200) {
                    Log.i("TEST","向上滑动手势");
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TEST","ev = "+ev.getAction());
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {//在这里onTouchEvent方法不相应，需要重写dispatchTouchEvent方法
//        Log.i("TEST","event = "+event.getAction());
//        mGestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
}
