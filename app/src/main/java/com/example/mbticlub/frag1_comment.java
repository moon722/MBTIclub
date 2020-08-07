package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class frag1_comment extends AppCompatActivity {
    Intent intent;
    ImageView imgview;
    TextView title, content;
    ImageButton backbtn, sendbtn;
    EditText msgtext;
    ListView listView;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1_comment);

        intent = new Intent();
        setContentView(R.layout.frag1_comment);
        intent = getIntent();
        //Log.e("포스트 도착",getString(intent.getIntExtra("img", 1)));

        backbtn = (ImageButton) findViewById(R.id.CommentBackBtn);
        imgview = (ImageView) findViewById(R.id.commentImg);
        title = (TextView) findViewById(R.id.comment_list_nam);
        content = (TextView) findViewById(R.id.comment_list_con);
        sendbtn = (ImageButton) findViewById(R.id.comment_Ibtn);
        msgtext = (EditText) findViewById(R.id.comment_Edt);

        intent = getIntent();   //intent 객체를 받아서 저장해오기(getintent())

        imgview.setImageResource(intent.getIntExtra("img", 1));

        final CommentAdapter commentAdapter = new CommentAdapter();
        listView = findViewById(R.id.comment_List);
        listView.setAdapter(commentAdapter);


        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = PreferenceManager.getString(context, "user_id");
                String user_name = PreferenceManager.getString(context, "user_name");
                String user_comment = msgtext.getText().toString();
                Toast.makeText(getApplicationContext(),user_name+""+user_comment, Toast.LENGTH_SHORT).show();

                Response.Listener<String> resStringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//댓글 작성에 성공한 경우
                                Toast.makeText(getApplicationContext(), "댓글작성 성공!", Toast.LENGTH_SHORT).show();
                            } else {//댓글 작성에 실패한 경우
                                Toast.makeText(getApplicationContext(), "댓글작성 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 Volley를 이용해서 요청
                CommentRegister commentRegister = new CommentRegister(user_id, user_name, user_comment, resStringListener);
                RequestQueue queue = Volley.newRequestQueue(frag1_comment.this);
                queue.add(commentRegister);

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
        @Override
        protected void onResume() {
            super.onResume();


    }

}