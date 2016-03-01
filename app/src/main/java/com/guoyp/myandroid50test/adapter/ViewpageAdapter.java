package com.guoyp.myandroid50test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by guoyp on 2016/2/26.
 */
public class ViewpageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;

    public ViewpageAdapter(FragmentManager fm, ArrayList<Fragment> list){
        super(fm);
        this.data = list;

    }
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab"+position;
    }
}
