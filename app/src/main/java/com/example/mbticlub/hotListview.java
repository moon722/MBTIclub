package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
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

        // 첫 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this,R.drawable.test1),"당신의 취미는?", "당신의 취미에 대해 알려주세요") ;
        // 두 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test2),
                "이런 전시회는 어때요?", "취향의 공유") ;
        // 세 번째 아이템 추가.
        hotad.addItem(ContextCompat.getDrawable(this, R.drawable.test3),
                "당신이 좋아하는 음식은?", "당신이 먹고싶은 음식을 선택해주세요") ;


    }
}