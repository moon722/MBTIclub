package com.example.mbticlub;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PostRegisterRequest extends StringRequest {
    //서버 URL설정(PHP 파일 연동)
    final static private String URL = "http://mbtiy.dothome.co.kr/PostRegister.php";
    private Map<String, String> map;


    public PostRegisterRequest(String post_user_id, String board_title, String post_title, String post_content, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("post_user_id",post_user_id);
        map.put("board_title",board_title);
        map.put("post_title",post_title);
        map.put("post_content",post_content);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
