package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ImageFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imagefragment2, container, false);

        ImageView imageView = view.findViewById(R.id.imageView2);
        if (getArguments() != null) {
            Bundle args = getArguments();
            // MainActivity에서 받아온 Resource를 ImageView에 셋팅
            imageView.setImageResource(args.getInt("imgRes"));
        }

        return view;
    }
    public void updateDetail(Bundle args) {
        Intent intent = new Intent(getActivity(), frag1_comment.class); //post액티비티 클래스로 보낼 intent객체 생성
        intent.putExtra("img",args.getInt("imgRes"));//객체에 보내야할 데이터 intent객체에 put()

        startActivity(intent);//intent를 가지고 post로 전달하면서 post액티비티 실행
        Log.e("intent 이벤트", getString(args.getInt("imgRes")));

    }
}
