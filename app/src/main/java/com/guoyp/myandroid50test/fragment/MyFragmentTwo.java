package com.guoyp.myandroid50test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyp.myandroid50test.R;

/**
 * Created by guoyp on 2016/2/26.
 */
public class MyFragmentTwo extends Fragment {
    private View fragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_two,container,false);
        return fragmentView;
    }
}
