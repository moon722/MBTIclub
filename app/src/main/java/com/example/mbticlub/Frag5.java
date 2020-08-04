package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class Frag5 extends Fragment {

    private ListView person_list;
    private View view;
    Intent intent;
    Button btn1;
    Button btn2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag5, container, false);

//        MBTI_selection = (Button)view.findViewById(R.id.MBTI_selection);
//        board_title = (TextView)view.findViewById(R.id.board_title);


        person_list = (ListView) view.findViewById(R.id.person_list);

        List<String> person_data = new ArrayList<>();//arraylist 배열 안에 스트링 형태로 리스트를 만들겠다
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, person_data);
        person_list.setAdapter(adapter);

        person_data.add("내 정보 관리");
        person_data.add("구독 정보");
        person_data.add("코인 충전");
        person_data.add("설문 관리");
        person_data.add("로그아웃");
        person_data.add("계정탈퇴");

        adapter.notifyDataSetChanged();

        btn1 = (Button)view.findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(),FragArticle.class);
                startActivity(intent);
            }
        });


        return view;
    }
}