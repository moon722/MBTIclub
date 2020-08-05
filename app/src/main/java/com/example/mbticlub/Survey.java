package com.example.mbticlub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Survey extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;
    ImageView imageView2;

    // Generate > Constructor

    public Survey(Context context) {
        super(context);

        init(context);
    }

    public Survey(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.frag5_surveycontent, this, true);

        textView = (TextView) findViewById(R.id.survey_textView);
        textView2 = (TextView) findViewById(R.id.survey_textView2);
        imageView = (ImageView) findViewById(R.id.survey_imageView);
        imageView2 = (ImageView) findViewById(R.id.surveyresult_imageView);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

    public void setImageView2(int evaluation) {imageView2.setImageResource(evaluation);}
}