package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class infoList extends AppCompatActivity {
    final private ListViewAdapter1 info_board = new ListViewAdapter1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_list);

        String[] board_items=new String[]{"전체게시판","자유게시판","여행","연애","게임","운동","영화","독서","소모임"};
        for(String item:board_items){
            info_board.addItem(R.drawable.ic_baseline_star_border_24,item);
        }
        ListView info_list = findViewById(R.id.infoList);
        info_list.setAdapter(info_board);

        info_board.notifyDataSetChanged();

        ImageButton info_back = (ImageButton) findViewById(R.id.BackBtn_info);
        info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}