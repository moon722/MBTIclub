package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2 # newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    ImageButton btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
//    public static BlankFragment2 newInstance(String param1, String param2) {
//        BlankFragment2 fragment = new BlankFragment2();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    private View view;
    ListView chat_listview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank2, container, false);

//        Fragment postlist_frag = new PostListFrag();
//        arguments = new Bundle();
//        arguments.putInt("background",current_backgound_param);
//        postlist_frag.setArguments(arguments);
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_frame,postlist_frag);
//        transaction.addToBackStack(null);

        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//
        final ChatAdapter chat_adapter = new ChatAdapter();
        chat_listview = view.findViewById(R.id.chat_list);
        chat_listview.setAdapter(chat_adapter);
        add_item(chat_adapter);
//        arguments.putString("board_title",board_adapter.board_name);

        btn = view.findViewById(R.id.chat_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1_intent = new Intent(getActivity(), Matching.class);
                startActivity(btn1_intent);
            }
        });


        return view;

    }

    public void add_item(ChatAdapter chatlist_adapter) {
        String[] chat_user = new String[]{"MrPark","Injoo"};
        String[] chat_items = new String[]{"Have a great one!", "I love programming!"};
        for(int i = 0; i < 2; i++){
            chatlist_adapter.addItem(chat_user[i],R.drawable.ic_baseline_person_24,chat_items[i]);
        }

        chatlist_adapter.notifyDataSetChanged();
    }

}