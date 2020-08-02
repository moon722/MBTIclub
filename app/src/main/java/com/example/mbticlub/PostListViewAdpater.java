//package com.example.mbticlub;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;

//대신 ListVewItemAdapter 써볼것
//
//class PostListViewAdapter extends BaseAdapter {
//    private ImageView iconImageView;
//    private TextView titleTextView;
////    private TextView contentTextView;
//
//    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
//    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
//
//    //PostListViewAdapter의 생성자
//    public PostListViewAdapter(){
//
//    }
//
//    //Adapter에 사용되는 데이터의 개수를 리턴
//    @Override
//    public int getCount(){
//        return listViewItemList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listViewItemList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        final int pos = position;
//        final Context context = parent.getContext();
//
//        //"board_listview_item" Layout을 infalte하여 convertView참조 획득
//        if(convertView == null){
//            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView=inflater.inflate(R.layout.board_listview_item,parent,false);
//
//        }
//        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
//        titleTextView=(TextView)convertView.findViewById(R.id.board_item_title);
//        iconImageView= (ImageView) convertView.findViewById(R.id.board_item_icon);
////        contentTextView=(TextView)convertView.findViewById(R.id.board_item_content);
//
//        ListViewItem listViewItem = listViewItemList.get(position);
//
//        //아이템 내 각 위젯에 데이터 반영
//        titleTextView.setText(listViewItem.getTitle());
//        iconImageView.setImageDrawable(listViewItem.getIcon());
////        contentTextView.setText(listViewItem.getDesc());
//
//        return convertView;
//
//    }
//    //아이템 데이터 추가를 위한 함수
//    public void addItem(String title, Drawable icon, String content){
//        ListViewItem item = new ListViewItem();
//
//        item.setTitle(title);
//        item.setIcon(icon);
////        item.setDesc(content);
//        listViewItemList.add(item);
//    }
//
//}
