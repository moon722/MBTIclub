package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class hotListview extends AppCompatActivity {

    private  ListViewAdapter hotad;
    private  ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_post);

        hotad = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.hotlistView);
        listview.setAdapter(hotad);
//        listview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                return false;
//            }
//        };


        // 첫 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test1),
                "Hobby list for engineers", "Tell me what you do for fun!");
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "Choose your taste", "Weekly best exhibition!") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "What is your favorite food?", "MBTI Food preference?!") ;

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        listview.measure(0, expandSpec);
        listview.getLayoutParams().height = listview.getMeasuredHeight();

        ImageButton back_ho = findViewById(R.id.BackBtn_ho);
        back_ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}