package com.example.mbticlub;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class QuestionDBItem {

    private String[] mData;

    public QuestionDBItem(String[] data ){


        mData = data;
    }

    public QuestionDBItem(String imgurl, String txt1, String txt2){

        mData = new String[3];
        mData[0] = imgurl;
        mData[1] = txt1;
        mData[2] = txt2;

    }

    public String[] getData(){
        return mData;
    }

    public String getData(int index){
        return mData[index];
    }

    public void setData(String[] data){
        mData = data;
    }



}
