package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Matching extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        // ViewPager와  FragmentAdapter 연결
        ViewPager viewPager = findViewById(R.id.izviewPager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setClipToPadding(false);

        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin / 2);

        ArrayList<Integer> listImage = new ArrayList<>();

        listImage.add(R.drawable.content1);
        listImage.add(R.drawable.content2);
        listImage.add(R.drawable.content3);

        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
        for (int i = 0; i < listImage.size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }
        fragmentAdapter.notifyDataSetChanged();
    }
}


