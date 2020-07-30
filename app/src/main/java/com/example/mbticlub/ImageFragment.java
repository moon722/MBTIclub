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

public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        if (getArguments() != null) {
            Bundle args = getArguments();
            // MainActivity에서 받아온 Resource를 ImageView에 셋팅
            imageView.setImageResource(args.getInt("imgRes"));
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = getArguments();
                Log.e("asdf",getString(args.getInt("imgRes")));
                updateDetail(args);

            }
        });
        return view;
    }
    public void updateDetail(Bundle args) {
        Intent intent = new Intent(getActivity(), PostActivity.class);
        intent.putExtra("img",args.getInt("imgRes"));

        startActivity(intent);
        Log.e("intent 이벤트", getString(args.getInt("imgRes")));

    }
}
