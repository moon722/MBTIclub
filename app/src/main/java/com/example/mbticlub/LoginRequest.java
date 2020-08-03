package com.example.mbticlub;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 URL설정(PHP 파일 연동)
    final static private String URL = "http://mbtiy.dothome.co.kr/Login.php";
    private Map<String, String> map;


    public LoginRequest(String user_id, String user_password, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("user_password",user_password);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}


