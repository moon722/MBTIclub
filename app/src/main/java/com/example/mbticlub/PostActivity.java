package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    Intent intent;
    ImageView imgview;
    TextView title, content;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("포스트도착","포스트");
        setContentView(R.layout.post);
        intent = getIntent();
        Log.e("포스트 도착",getString(intent.getIntExtra("img", 1)));


        imgview = (ImageView)findViewById(R.id.img);
        //title = (TextView)findViewById(R.id.Posttitle);
        //content  = (TextView)findViewById(R.id.Postcontent);
        intent = getIntent();
        imgview.setImageResource(intent.getIntExtra("img",1 ));
        //int  img = intent.getIntExtra("img");
        //imgview.setImageResource(img);





        //intent = getIntent();
        //intent.getExtras().getString("imgRes");
    }
}
