package com.example.mbticlub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Frag4 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4,container,false);

        ViewPager vp = view.findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getFragmentManager());
        vp.setAdapter(adapter);

        TabLayout tab = view.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

        ArrayList<Integer> images = new ArrayList<Integer>();
        images.add(R.drawable.ic_not);
        images.add(R.drawable.ic_cha);

        for(int i=0; i<2; i++) tab.getTabAt(i).setIcon(images.get(i));

        return view;

    }
}