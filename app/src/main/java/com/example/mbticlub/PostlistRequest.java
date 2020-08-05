package com.example.mbticlub;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PostlistRequest extends StringRequest {
    //서버 URL설정(PHP 파일 연동)
    final static private String URL = "http://mbtiy.dothome.co.kr/POST_USER.php";
//    final static private String URL = "http://mbtiy.dothome.co.kr/Post_has_User_ver2.php";

    private Map<String, String> map;


    public PostlistRequest( String board_title, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("board_title", board_title);


    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
