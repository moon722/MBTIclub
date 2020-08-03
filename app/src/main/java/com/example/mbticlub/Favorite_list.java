package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Favorite_list extends AppCompatActivity {

    final private ListViewAdapter1 fa_board = new ListViewAdapter1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list);


        String[] board_items=new String[]{"전체게시판","자유게시판","여행","연애","게임","운동","영화","독서","소모임"};
        for(String item:board_items){
            fa_board.addItem(R.drawable.ic_baseline_star_border_24,item);
        }

        fa_board.notifyDataSetChanged();

        ImageButton back_fa = findViewById(R.id.BackBtn_fa);
        back_fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}