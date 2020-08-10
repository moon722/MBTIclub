package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class FragArticle extends AppCompatActivity {
    private TextView titleTextView;
    private ImageView iconImageView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<MListViewItem> listViewItemList = new ArrayList<MListViewItem>();
    public ArrayList<MListViewItem> filteredItemList = listViewItemList;

    public String board_name;

    //fragment transaction
    private FragmentManager boardFragementManager;
    private FragmentTransaction boardFragmentTranscation;
    private FragmentActivity boardFragmentActivity;

    private Frag5 fragment;
    Intent intent;

    PostListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag5_communityarticle);
        getIntent();

        ListView listView = (ListView) findViewById(R.id.person_communityarticle_list);

        adapter = new PostListViewAdapter();

        adapter.addItem("Faker", "여친 생일선물 추천", "여친 생일선물로 뭘 해줄지 고민중....", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "영화 추천해주세요!!", "코로나로 집에만 있는데 영화 추천해주실 분?", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "레알 챔스 떨어지다니 ㅎㄷㄷ..", "팀 떨어졌는데 베일은 ㅋ", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "여러분 저 고양이 키워요!!", "오늘 고양이 분양받는다 ㅎ", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "여친 생일선물 추천", "여친 생일선물로 뭘 해줄지 고민중....", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "문인주 교수님 데베", "ㄹㅇ꿀강이지만 내 머리는 못따라가는걸?", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "나는 개똥벌레", "친구가 없네~~", R.drawable.ic_baseline_person_24);
        adapter.addItem("Faker", "여친 생일선물 추천", "여친 생일선물로 뭘 해줄지 고민중....", R.drawable.ic_baseline_person_24);

        listView.setAdapter(adapter);


    }


}