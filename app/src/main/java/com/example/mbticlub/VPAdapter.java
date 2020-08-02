package com.example.mbticlub;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter{

    int mNumofTabs;

    private ArrayList<String> itext = new ArrayList<String>();
    public VPAdapter(FragmentManager fm) {
        super(fm);
        this.mNumofTabs = 2;

        itext.add("Notifications");
        itext.add("Message");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                BlankFragment tab1 = new BlankFragment();
                return tab1;
            case 1:
                BlankFragment2 tab2 = new BlankFragment2();
                return tab2;
            default:
                return null;
        }
//        return items.get(position);
    }

    @Override
    public int getCount() {
        return mNumofTabs;
//        return items.size();
    }



}
