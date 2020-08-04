package com.example.mbticlub;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private int tabCount = 2;
    //private ArrayList<String> itext = new ArrayList<String>();
    public TabPagerAdapter(FragmentManager fm){
        super(fm);
//        this.tabCount = 2;
//        itext.add("My Friends");
//        itext.add("ADD Friends");
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "My friends";
            case 1:
                return "Add friends";
            default:
                return null;
        }
    }
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return itext.get(position);
//    }

//    @Override
//    public Fragment getItem(int position){
//        switch (position){
//            case 0:
//                friend_frag fr1 = new friend_frag();
//                return fr1;
//            case 1:
//                friend_frag1 fr2 = new friend_frag1();
//                return fr2;
//            default:
//                return null;
//
//        }
//    }
@Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return friend_frag.newInstance();
            case 1:
                return friend_frag1.newInstance();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
