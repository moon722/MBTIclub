package com.example.mbticlub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter_fourviewer extends BaseAdapter {

    private ImageView iconImageView;
    private TextView contentTextView;
    private Button okBtn;
    private Button noBtn;
    private ArrayList<ListViewItem1> listViewItems = new ArrayList<ListViewItem1>();

    //생성자
    public ListViewAdapter_fourviewer() {
    }

    //개수 리턴
    @Override
    public int getCount(){
        return listViewItems.size();
    }
    //position에 위치한 데이터를 화면에 출력하는데 사용될 View 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();
        //listview_item 레이아웃을 inflate 하여 convertView 참조 획득.
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
            convertView = inflater.inflate(R.layout.frag4_friend_req, parent, false);
        }

        //화면에 표시될 View 로부터 위젯에 대한 참조 획득.
        iconImageView = (ImageView) convertView.findViewById(R.id.friend_Igv);
        contentTextView = (TextView) convertView.findViewById(R.id.friend_name);
        okBtn = (Button) convertView.findViewById(R.id.friend_okbtn);
        noBtn = (Button) convertView.findViewById(R.id.friend_nobtn);

        final ListViewItem1 listViewItem = listViewItems.get(position);

        //각 리스트에 데이터 반영
        iconImageView.setImageResource(listViewItem.getIconDrawable());
        contentTextView.setText(listViewItem.getContentStr());

 //       final LinearLayout listItem = (LinearLayout) convertView.findViewById(R.id.friend_Linear);

//        listItem.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                //해당 리스트 클릭시 이벤트
//                Toast.makeText(v.getContext(),listViewItems.get(pos).getContentStr(), Toast.LENGTH_SHORT).show();
//                Intent intent;
//                switch (pos){
//                    case 0: intent = new Intent(v.getContext(), hotListview.class);
//                    break;
//                    case 1: intent = new Intent(v.getContext(), Favorite_list.class);
//                    break;
//                    case 2: intent = new Intent(v.getContext(), infoList.class);
//                    break;
//                    default: intent = null;
//                        break;
//                }
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                v.getContext().startActivity(intent);
//
//            }
//        });


        return convertView;
    }

    //지정한 위치에 있는 데이터와 관계된 아이템의 ID 리턴
    @Override
    public long getItemId(int position){
        return position;
    }

    //지정한 위치에 있는 데이터 리턴
    @Override
    public Object getItem(int  position){
        return listViewItems.get(position);
    }

    //아이템 데이터 추가를 위한 함수

    public void addItem(int icon, String content ){
        ListViewItem1 item = new ListViewItem1();

        item.setIconDrawable(icon);
        item.setContentStr(content);

        listViewItems.add(item);
    }

}
