package com.guoyp.myandroid50test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class FragmentThree extends BaseFragment {
    private View fragmentView;
    private boolean isViewCreat = false;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_three,container,false);
        isViewCreat = true;
        return fragmentView;
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if(isViewCreat){
            Snackbar.make(fragmentView,"333333333333",Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isViewCreat = false;
    }
}
