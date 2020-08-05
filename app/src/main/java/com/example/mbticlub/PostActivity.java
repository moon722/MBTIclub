package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    Intent intent;
    ImageView imgview;
    TextView title, content;
    ImageButton backbtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("포스트도착","포스트");
        setContentView(R.layout.post);
        intent = getIntent();
        Log.e("포스트 도착",getString(intent.getIntExtra("img", 1)));

        backbtn = (ImageButton)findViewById(R.id.ListBackBtn);
        imgview = (ImageView)findViewById(R.id.img);
        title = (TextView)findViewById(R.id.Posttitle);
        content  = (TextView)findViewById(R.id.Postcontent);
        intent = getIntent();   //intent 객체를 받아서 저장해오기(getintent())

        imgview.setImageResource(intent.getIntExtra("img",1 ));

        title.setText("asdf");//이미지 리소스에 대한 title, content 데이터 db에서 받아오기
        content.setText("asdf");


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
