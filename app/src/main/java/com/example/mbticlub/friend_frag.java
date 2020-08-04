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
        ListView fr_list = (ListView) view.findViewById(R.id.friend_list1);
        final ChatAdapter adapter = new ChatAdapter();
        fr_list.setAdapter(adapter);
        add_item(adapter);

        return view;
    }

    public void add_item(ChatAdapter chatlist_adapter) {
        String[] chat_user = new String[]{"후후히히","민찬","인주","태하","혜림","상진"};
        String[] chat_items = new String[]{"오늘도 좋은 하루 보내", "왜 이거 안돼 개빡쳐","나는 코딩이 좋아","저는 코딩빼고 다 할 수 있습니다.","안드로이드는 저에게!","인주버스가 이리 편한지 몰랐어요"};
        for(int i = 0; i < 2; i++){
            chatlist_adapter.addItem(chat_user[i],R.drawable.ic_baseline_person_24,chat_items[i]);
        }

        chatlist_adapter.notifyDataSetChanged();
    }
}