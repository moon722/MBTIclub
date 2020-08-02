package com.example.mbticlub;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class PostListFrag extends Fragment{

    private View view;
    LinearLayout background;

    ListView post_listview;
    EditText post_editText_filter;
    int current_backgound=R.color.INTP;

    //        -----------------
    Bundle receive_argu;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.post_listview,container,false);
        background = (LinearLayout)view.findViewById(R.id.board_background);

//        receive_argu = this.getArguments();
        current_backgound = getArguments().getInt("background");




        final PostListViewAdapter postlist_adapter=new PostListViewAdapter();
        post_listview = (ListView)view.findViewById(R.id.post_listview);
        post_listview.setAdapter(postlist_adapter);
        add_item(postlist_adapter);

        post_editText_filter=(EditText)view.findViewById(R.id.post_textSearch);
        post_editText_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                postlist_adapter.getFilter().filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        ------------------------ board_title

        //add data to listview

//        final int[] board_colors = {R.color.INTJ,R.color.INTP,R.color.ENTJ,R.color.ENTP,
//                R.color.INFJ,R.color.INFP,R.color.ENFJ,R.color.ENFP,
//                R.color.ISTJ,R.color.INFJ,R.color.ESTJ,R.color.ESFJ,
//                R.color.ISTP,R.color.ISFP,R.color.ESTP,R.color.ESFP};
        final TextView board_title = (TextView) view.findViewById(R.id.edit_post_BoardName);
//        board_title.setText(receive_argu.getString("board_title"));

        background.setBackgroundResource(current_backgound);



        return view;
    }

    public void add_item(PostListViewAdapter postlist_adapter){
        String[] post_content=new String[]{"전체게시판","자유게시판","여행","연애","게임","운동","영화","독서","소모임"};
        for(String item:post_content){
            postlist_adapter.addItem("익명",R.drawable.ic_baseline_person_24,item);
        }

        postlist_adapter.notifyDataSetChanged();
    }

}
