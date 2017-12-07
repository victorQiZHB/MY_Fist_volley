package com.example.my_fist_volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by robot on 2017/12/6.
 */

public class MyApplication extends Application {


    //volley 全局请求队列对象
    public static RequestQueue sRequestQueue;

    /**
     * @return Volley全局请求队列
     */

    public static RequestQueue getRequestQueue(){
        return sRequestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //实例化Volley全局请求队列

        sRequestQueue = Volley.newRequestQueue(getApplicationContext());


    }
}
