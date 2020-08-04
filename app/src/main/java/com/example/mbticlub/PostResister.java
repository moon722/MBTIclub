package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PostResister extends AppCompatActivity {
    Intent intent;
    EditText edit_post_title;
    EditText edit_post_content;
    Button post_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_resister);
        intent = getIntent();
        final Context context = this;

        edit_post_title = findViewById(R.id.post_register_title);
        edit_post_content = findViewById(R.id.post_register_content);
        post_register = findViewById(R.id.post_register_button);

        post_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 현재 입력되어있는 값을 가져온다
//                SharedPreferences sf = getSharedPreferences("user_info",MODE_PRIVATE);
//                String post_user_id = sf.getString("user_id","띠용");
                String post_user_id = PreferenceManager.getString(context,"user_id");

                String board_title = intent.getStringExtra("board_title");
//                String post_user_id = "띠용";
//                String board_title = "board_title";
                String post_title = edit_post_title.getText().toString();
                String post_content = edit_post_content.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//회원 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "글쓰기를 성공했습니다", Toast.LENGTH_SHORT).show();
                                //로그인 화면으로 돌아감
//                                Intent intent = new Intent(PostResister.this, PostlistActivity.class);
//                                PostResister.this.startActivity(intent);
                                finish();
                            } else {//회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "글쓰기를 실패했습니다", Toast.LENGTH_SHORT).show();
                                return;


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                PostResisterRequest postResisterRequest = new PostResisterRequest(post_user_id, board_title, post_title, post_content, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostResister.this);
                queue.add(postResisterRequest);


            }

        });
    }
}