package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test1), "당신의 취미는?", "당신의 취미에 대해 알려주세요");
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "이런 전시회는 어때요?", "취향의 공유") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "당신이 좋아하는 음식은?", "당신이 먹고싶은 음식을 선택해주세요") ;
        hotad.addItem(ContextCompat.getDrawable(this,R.drawable.test1),"당신의 취미는?", "당신의 취미에 대해 알려주세요") ;
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "이런 전시회는 어때요?", "취향의 공유") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "당신이 좋아하는 음식은?", "당신이 먹고싶은 음식을 선택해주세요") ;
        hotad.addItem(ContextCompat.getDrawable(this,R.drawable.test1),"당신의 취미는?", "당신의 취미에 대해 알려주세요") ;
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "이런 전시회는 어때요?", "취향의 공유") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "당신이 좋아하는 음식은?", "당신이 먹고싶은 음식을 선택해주세요") ;
        hotad.addItem(ContextCompat.getDrawable(this,R.drawable.test1),"당신의 취미는?", "당신의 취미에 대해 알려주세요") ;
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "이런 전시회는 어때요?", "취향의 공유") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "당신이 좋아하는 음식은?", "당신이 먹고싶은 음식을 선택해주세요") ;

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        listview.measure(0, expandSpec);
        listview.getLayoutParams().height = listview.getMeasuredHeight();
    }
}