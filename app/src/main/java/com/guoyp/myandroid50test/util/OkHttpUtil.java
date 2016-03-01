package com.guoyp.myandroid50test.util;

import android.app.Activity;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by guoyp on 2016/2/29.
 */
public class OkHttpUtil {
    private OkHttpClient mOkHttpClient;

    public OkHttpUtil(){
        if (mOkHttpClient == null)
            mOkHttpClient = new OkHttpClient();
    }

    public void sendGet(String url,final OkHttpUtilCallback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
//                String result = request.body().toString();
                String error = e.getMessage().toString();
                if(callback != null){
                    callback.onError(error);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String result = response.body().toString();
                if(callback != null) callback.onResult(result);
            }
        });
    }

    public void sendPost(String url,OkHttpUtilCallback callback,String[] params){
        if(params != null){
            FormEncodingBuilder builder = new FormEncodingBuilder();
            for (String param:params){
//                builder.add();
            }
        }

    }

    public interface  OkHttpUtilCallback{
        void onResult(String result);
        void onError(String error);
    }
}
