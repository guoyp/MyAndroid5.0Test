package com.guoyp.myandroid50test.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyp.myandroid50test.BaseFragment;
import com.guoyp.myandroid50test.R;

/**
 * Created by guoyp on 2016/2/26.
 */
public class MyFragment extends BaseFragment {
    private View fragmentView;
    private boolean isViewCreatOne = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_one,container,false);
        isViewCreatOne = true;
        return fragmentView;
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if(isViewCreatOne){
            Snackbar.make(fragmentView,"1111111111111111",Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isViewCreatOne = false;
    }
}
