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

        board_data.add("자유게시판\n 답글 : 안녕하세요");
        board_data.add("친구요청(1)\n 닉네임 : 오픈클러스터");
        board_data.add("새로운 대화가 매칭되었습니다\n닉네임 : 곰돌이푸 (ENTP)");
        board_data.add("코인 알림\n뉴스레터 구독을 위한 코인이 부족합니다!");
        board_data.add("자유게시판\n 답글 : 안녕하세요");
        board_data.add("친구요청(1)\n 닉네임 : 오픈클러스터");
        board_data.add("새로운 대화가 매칭되었습니다\n닉네임 : 곰돌이푸 (ENTP)");
        board_data.add("코인 알림\n뉴스레터 구독을 위한 코인이 부족합니다!");
        board_data.add("자유게시판\n 답글 : 안녕하세요");
        board_data.add("친구요청(1)\n 닉네임 : 오픈클러스터");
        board_data.add("새로운 대화가 매칭되었습니다\n닉네임 : 곰돌이푸 (ENTP)");
        board_data.add("새로운 대화가 매칭되었습니다\n닉네임 : 곰돌이푸 (ENTP)");
        board_data.add("새로운 대화가 매칭되었습니다\n닉네임 : 곰돌이푸 (ENTP)");
        board_data.add("코인 알림\n뉴스레터 구독을 위한 코인이 부족합니다!");

        adapter.notifyDataSetChanged();//이 상태를 저장

        return view;
    }
}