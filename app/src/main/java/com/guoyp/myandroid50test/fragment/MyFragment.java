package com.guoyp.myandroid50test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoyp.myandroid50test.R;

/**
 * Created by guoyp on 2016/2/26.
 */
public class MyFragment extends Fragment {
    private View fragmentView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_one,container,false);
        return fragmentView;
    }
}
