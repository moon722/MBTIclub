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
        final ChatAdapter adapter1 = new ChatAdapter();
        fr_list1.setAdapter(adapter1);
        add_item(adapter1);

        return view;
    }

    public void add_item(ChatAdapter chatlist_adapter) {
        String[] chat_user = new String[]{"후후히히","민찬"};
        String[] chat_items = new String[]{"오늘도 좋은 하루 보내", "나는 코딩이 좋아"};
        for(int i = 0; i < 2; i++){
            chatlist_adapter.addItem(chat_user[i],R.drawable.ic_baseline_person_24,chat_items[i]);
        }

        chatlist_adapter.notifyDataSetChanged();
    }
}