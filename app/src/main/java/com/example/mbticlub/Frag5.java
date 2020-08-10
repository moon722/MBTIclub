package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
    List<Integer> list_position;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag5, container, false);

//        MBTI_selection = (Button)view.findViewById(R.id.MBTI_selection);
//        board_title = (TextView)view.findViewById(R.id.board_title);


        person_list = (ListView) view.findViewById(R.id.person_list);

        List<String> person_data = new ArrayList<>();//arraylist 배열 안에 스트링 형태로 리스트를 만들겠다
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, person_data);
        person_list.setAdapter(adapter);

        person_data.add("Edit Profile");
        person_data.add("Subscription");
        person_data.add("Charge Up");
        person_data.add("Research History");
        person_data.add("Logout");

        adapter.notifyDataSetChanged();



        person_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent my_article = new Intent(getActivity(),FragMyInfo.class);
                        getActivity().startActivity(my_article);
                        break;
                    case 1:
                        Intent my_subscribe = new Intent(getActivity(),FragSubscribe.class);
                        getActivity().startActivity(my_subscribe);
                        break;
                    case 2:
                        Intent coin_intent = new Intent(getActivity(), FragCoin.class);
                        getActivity().startActivity(coin_intent);
                        break;
                    case 3:
                        Intent my_survey = new Intent(getActivity(),FragSurvey.class);
                        getActivity().startActivity(my_survey);
                        break;
                    case 4:
                        Intent logout = new Intent(getActivity(),LoginScreen.class);
                        getActivity().startActivity(logout);
                        break;
                }
            }
        });


        btn1 = (Button)view.findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1_intent = new Intent(getActivity(), FragArticle.class);
                startActivity(btn1_intent);
            }
        });



        btn2 = (Button) view.findViewById(R.id.button2);
        btn2.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn2_intent = new Intent(getActivity(), friends_list.class);
                startActivity(btn2_intent);
            }
        });


        return view;
    }
}