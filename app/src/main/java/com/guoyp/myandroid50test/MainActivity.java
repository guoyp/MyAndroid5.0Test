package com.guoyp.myandroid50test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.guoyp.myandroid50test.adapter.MyRecyclerView;

/**
 * Created by guoyp on 2016/2/26.
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private LinearLayout layout_one;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();

    }

    private void init(){
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("MainActivity");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ico_user);

        layout_one = (LinearLayout) findViewById(R.id.layout_one);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.myct);
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

        mRecyclerView = (RecyclerView) findViewById(R.id.myrecyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        MyRecyclerView adapter = new MyRecyclerView();
        adapter.setOnItemClick(new MyRecyclerView.MyRecyclerItemClick() {
            @Override
            public void click(int position) {
                Snackbar.make(layout_one,"item "+position,Snackbar.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(adapter);


    }
    private void setListener(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Hello word",Snackbar.LENGTH_LONG).show();
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        layout_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"item 01",Toast.LENGTH_LONG).show();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add("item 01");
        menu.add(0,0,0,"item 02");
        menu.add(0, 1, 0, "item 03");
        menu.add(0,2,0,"item 04");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case 0:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent it = new Intent(MainActivity.this,TextInputActivity.class);
                startActivity(it);
                break;
            case 2:
                final Snackbar sk = Snackbar.make(toolbar, "item 04", Snackbar.LENGTH_LONG);
                sk.setAction("click me", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//Snackbar添加action
                        sk.setText("item 04 clicked");
                    }
                }).show();
                break;

            case R.id.action_edit:
                Snackbar.make(toolbar,"join card",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Intent mIntent = new Intent(MainActivity.this,NavigationActivity.class);
                startActivity(mIntent);
                break;
            default:
                break;

        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
