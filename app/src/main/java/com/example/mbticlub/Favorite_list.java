package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class Favorite_list extends AppCompatActivity {

    final private ListViewAdapter1 fa_board = new ListViewAdapter1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list);


        String[] board_items=new String[]{"All","Anything","Travel","Relationship","Video game","Sports","Films","Books","Meet-up"};
        for(String item:board_items){
            fa_board.addItem(R.drawable.ic_baseline_star_border_24,item);
        }

        ListView fa_list = findViewById(R.id.fa_listview);
        fa_list.setAdapter(fa_board);

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