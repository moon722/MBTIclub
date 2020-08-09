package com.example.mbticlub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class friend_frag1 extends Fragment {

public static friend_frag1 newInstance() {
    Bundle args = new Bundle();

    friend_frag1 fragment = new friend_frag1();
    fragment.setArguments(args);
    return fragment;
}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_frag1, container, false);
        //super.onCreate(savedInstanceState);

        ListView fr_list1 = (ListView) view.findViewById(R.id.friend_list1);
        final ListViewAdapter_fourviewer adapter1 = new ListViewAdapter_fourviewer();
        fr_list1.setAdapter(adapter1);
        add_item(adapter1);

        return view;
    }

    public void add_item(ListViewAdapter_fourviewer chatlist_adapter) {
        String[] chat_user = new String[]{"injoo","minchan"};
        for(int i = 0; i < 2; i++){
            chatlist_adapter.addItem(R.drawable.ic_baseline_person_24,chat_user[i]);
        }

        chatlist_adapter.notifyDataSetChanged();
    }
}