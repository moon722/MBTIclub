package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class friends_list extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);
        getIntent();


//        ArrayList<Integer> images = new ArrayList<Integer>();
//        images.add(R.drawable.ic_not);
//        images.add(R.drawable.ic_cha);
//
//        for(int i=0; i<2; i++) tabs.getTabAt(i).setIcon(images.get(i));
        //tabs.setTabGravity(tabs.GRAVITY_FILL);

        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_fr);
        viewPager.setAdapter(pagerAdapter);
        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
       TabLayout tabs = findViewById(R.id.tabs);
//        tabs.addTab(tabs.newTab().setText("My friends"));
//        tabs.addTab(tabs.newTab().setText("add friends"));
//        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_baseline_person_24));
//        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_baseline_notifications_24));

        tabs.setupWithViewPager(viewPager);
//        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
//            public void onTabSelected (TabLayout.Tab tab){
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}