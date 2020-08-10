package com.example.mbticlub;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mbticlub.R;

public class GridViewer extends LinearLayout {
    GridItem gridItem;
    Context context;
    TextView textView;
    ImageView imageView;
    public GridViewer(Context context) {
        super(context);

        init(context);
    }

    public GridViewer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gridview,this,true);

        textView = (TextView)findViewById(R.id.gridtext);
        imageView = (ImageView) findViewById(R.id.gridimg);
    }

    public void setItem(GridItem singerItem){

        textView.setText(singerItem.getName());
        imageView.setImageResource(context.getResources().getIdentifier(gridItem.getImage(),"drawable",context.getPackageName()));
    }
}