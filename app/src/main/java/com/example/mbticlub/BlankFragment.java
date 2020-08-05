package com.example.mbticlub;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment # newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private View view;
    private ListView board_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank, container, false);

//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.height = 100;
//        view.setLayoutParams(layoutParams);

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        board_list = (ListView) view.findViewById(R.id.board_list);

        List<String> board_data = new ArrayList<>();//arraylist 배열 안에 스트링 형태로 리스트를 만들겠다
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.memolist_type, board_data);
        board_list.setAdapter(adapter);

        board_data.add("[Report Alert]\nYour report is under review");
        board_data.add("[Comments /Anything]\nNick : Thank you:)");
        board_data.add("[Friend Request]\nName : Open Cluster (INTJ)");
        board_data.add("!New match arrived for you!\nName : MrPark (ENTP)");
        board_data.add("[Coin Alert]\nRunning our of coins for newletter!");
        board_data.add("[New Friend]\nLEEG accepted your friend request");
        board_data.add("[Comments /Travel]\nWhale : Love this spot!!");
        board_data.add("[Coin Alert]\nRunning our of coins for newletter!");
        board_data.add("[New Friend]\nBTSWORLD accepted your friend request");
        board_data.add("[New Friend]\nMbtiAddict accepted your friend request");
        board_data.add("[Welcome Gift]\nYou earned 20 coins!!");

        adapter.notifyDataSetChanged();//이 상태를 저장

        return view;
    }
}