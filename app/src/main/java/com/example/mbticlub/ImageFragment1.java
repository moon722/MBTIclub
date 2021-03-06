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

public class ImageFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        if (getArguments() != null) {
            Bundle args = getArguments();
            // frag1에서 받아온 Resource를 ImageView에 셋팅
            imageView.setImageResource(args.getInt("imgRes"));
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//클릭 할 때마다 intent(updateDetail()실행) 전달
                Bundle args = getArguments();
                Log.e("title",getString(args.getInt("imgRes")));
                updateDetail(args);

            }
        });
        return view;
    }
    public void updateDetail(Bundle args) {
        Intent intent = new Intent(getActivity(), frag1_comment.class); //post액티비티 클래스로 보낼 intent객체 생성
        intent.putExtra("img",args.getInt("imgRes"));//객체에 보내야할 데이터 intent객체에 put()
        intent.putExtra("value", args.getString("ValRes"));

        startActivity(intent);//intent를 가지고 post로 전달하면서 post액티비티 실행
        Log.e("intent 이벤트", getString(args.getInt("imgRes")));

    }
}
