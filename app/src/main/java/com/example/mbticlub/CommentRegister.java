package com.example.mbticlub;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CommentRegister extends StringRequest {
    //서버 URL설정(PHP 파일 연동)
    final static private String URL = "http://mbtiy.dothome.co.kr/CommentRe.php";
    private Map<String, String> map;


    public CommentRegister(String user_id, String user_name, String user_comment, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("user_id",user_id);
        map.put("user_name",user_name);
        map.put("user_comment",user_comment);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
