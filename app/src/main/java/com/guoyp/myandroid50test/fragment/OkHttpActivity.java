package com.guoyp.myandroid50test.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.guoyp.myandroid50test.R;
import com.guoyp.myandroid50test.util.OkHttpUtil;

/**
 * Created by guoyp on 2016/2/29.
 */
public class OkHttpActivity extends AppCompatActivity implements OnClickListener {
    private Button btn_get;
    private OkHttpUtil mOkHttpUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        init();
    }
    private void init(){
        mOkHttpUtil = new OkHttpUtil();
        btn_get = (Button) findViewById(R.id.send_get);
        btn_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_get:
                mOkHttpUtil.sendGet("",new OkHttpUtil.OkHttpUtilCallback() {
                    @Override
                    public void onResult(String result) {

                    }

                    @Override
                    public void onError(String error) {

                    }
                });
                break;
            case R.id.send_post:

                break;
            default:
                break;
        }
    }
}
