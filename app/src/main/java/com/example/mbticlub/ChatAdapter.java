package com.example.mbticlub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
//대신 ListVewItemAdapter 써볼것

public class ChatAdapter extends BaseAdapter {
    private TextView titleTextView;
    private ImageView iconImageView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<ChatItem> listViewItemList = new ArrayList<ChatItem>();
    public ArrayList<ChatItem> filteredItemList = listViewItemList;

    //BoardListViewAdapter의 생성자
    public ChatAdapter(FragmentManager fm, FragmentTransaction ft, FragmentActivity fa){
    }

    //Adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount(){
        return filteredItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        //"board_listview_item" Layout을 infalte하여 convertView참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.chat_listview_item,parent,false);

        }
        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        titleTextView=(TextView)convertView.findViewById(R.id.board_item_title);
        iconImageView = (ImageView) convertView.findViewById(R.id.board_item_icon);


        final ChatItem chatItem = filteredItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(chatItem.getTitle());
        iconImageView.setImageResource(chatItem.getIcon());
//        contentTextView.setText(listViewItem.getDesc());
        titleTextView.setOnClickListener(new AdapterView.OnClickListener(){

            @Override
            public void onClick(View v) {
//                board_name = chatItem.getTitle();
//                boardFragmentTranscation.commit();
            }
        });

        return convertView;

    }

    //아이템 데이터 추가를 위한 함수
    public void addItem(String title, int icon){
        ChatItem item = new ChatItem();

        item.setTitle(title);
        item.setIcon(icon);
//        item.setDesc(content);
        listViewItemList.add(item);
    }

}
