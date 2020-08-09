package com.example.mbticlub;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class friend_frag extends Fragment {


public static friend_frag newInstance() {
        Bundle args = new Bundle();

        friend_frag fragment = new friend_frag();
        fragment.setArguments(args);
        return fragment;
    }

        @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_frag, container, false);
        //super.onCreate(savedInstanceState);
        ListView fr_list = (ListView) view.findViewById(R.id.friend_list);
        final ListViewAdapter1 adapter = new ListViewAdapter1();
        fr_list.setAdapter(adapter);
        add_item(adapter);

        return view;
    }

    public void add_item(ListViewAdapter1 chatlist_adapter) {
        String[] chat_user = new String[]{"minchan","injoo","tahea","heoyrim","sanggin"};
        for(int i = 0; i < chat_user.length; i++){
            chatlist_adapter.addItem(R.drawable.ic_baseline_person_24,chat_user[i]);
        }

        chatlist_adapter.notifyDataSetChanged();
    }
}