package com.guoyp.myandroid50test;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by guoyp on 2016/2/25.
 */
public class TextInputActivity extends AppCompatActivity {
    private TextInputLayout textinput_username,textinput_password;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinput);
        init();
        setListener();
    }
    private void init(){
        textinput_username = (TextInputLayout) findViewById(R.id.textinput_username);
        textinput_password = (TextInputLayout) findViewById(R.id.textinput_password);
        textinput_username.getEditText().addTextChangedListener(new MyTextWatcher(textinput_username,"用户名长度不能小于4位",0));
        textinput_password.getEditText().addTextChangedListener(new MyTextWatcher(textinput_password,"密码长度不能小于6位",1));
        mButton = (Button) findViewById(R.id.btn_show_snackbar);

    }
    private void setListener(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"注册成功",Snackbar.LENGTH_LONG).setAction("返回", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }).show();
            }
        });
    }

    class MyTextWatcher implements TextWatcher{

        private TextInputLayout TIlayout;
        private String error;
        private int type;

        public MyTextWatcher(TextInputLayout tix,String error,int type){
            this.TIlayout = tix;
            this.error = error;
            this.type = type;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int size;
            if(type == 0) {
                size = 4;
            }else {
                size = 6;
            }

            if(TIlayout.getEditText().getText().toString().length()<size){
                TIlayout.setErrorEnabled(true);
                TIlayout.setError(error);
            }else{
                TIlayout.setErrorEnabled(false);
            }

        }
    }
}
