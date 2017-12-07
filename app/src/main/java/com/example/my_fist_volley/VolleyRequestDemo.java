package com.example.my_fist_volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robot on 2017/12/7.
 */

public class VolleyRequestDemo {

    /**
     *  使用Volley的 stringRequest
     */
    private static final String volleyTag = "tag_volley_request";
    private static final String JUHE_APPKEY ="effd958a513778eadd21f8d29a675644";
    private static final String JUHE_API_URL ="http://v.juhe.cn/postcode/query";

    private String postcode = "210044";
    private String url_GET = JUHE_API_URL + "?postcode=" + postcode +"&key="+JUHE_APPKEY;


    public void volleyStringRequestDemo_GET(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_GET, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("请求成功","GET_StringRequest:"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("请求失败","GET_StringRequest:"+error);

            }
        });

        stringRequest.setTag(volleyTag);//将此请求 加入全局请求队列中
        MyApplication.getRequestQueue().add(stringRequest);

    }

    public void volleyJsonObjectReqeustDemo_GET(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_GET, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("请求成功","GET_StringRequest:"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("请求失败","GET_StringRequest:"+error);

            }
        });

        jsonObjectRequest.setTag(volleyTag);//设置tag
        MyApplication.getRequestQueue().add(jsonObjectRequest); //加入全局请求队列

    }

    public void volleyJsonArrayReqeustDemo_GET(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url_GET, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("请求成功","GET_StringRequest:"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("请求失败","GET_StringRequest:"+error);
            }
        });
        jsonArrayRequest.setTag(volleyTag);//设置tag
        MyApplication.getRequestQueue().add(jsonArrayRequest); //加入全局请求队列

    }


    /**
     * POST sringRequest 请求
     */

    public void volleyStringRequestDemo_POST() {
        String url = JUHE_API_URL;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> paramMap = new HashMap<>();
                paramMap.put("postcode",postcode);
                paramMap.put("key",JUHE_APPKEY);

                return  paramMap;
            }
        };

        stringRequest.setTag(volleyTag);//StringRequest_POST

        MyApplication.getRequestQueue().add(stringRequest);

    }

}
