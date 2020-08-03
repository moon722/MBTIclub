package com.example.mbticlub;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignupRequest extends StringRequest {

    //서버 URL설정(PHP 파일 연동)
    final static private String URL = "http://mbtiy.dothome.co.kr/Register.php";
    private Map<String, String> map;


    public SignupRequest(String user_id, String user_password, String user_name, String user_mbti, String user_mobile, String user_email, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("user_password",user_password);
        map.put("user_name",user_name);
        map.put("user_mbti",user_mbti);
        map.put("user_mobile",user_mobile);
        map.put("user_email",user_email);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}


