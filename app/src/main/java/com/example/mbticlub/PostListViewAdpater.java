package com.example.mbticlub;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//대신 ListVewItemAdapter 써볼것

class PostListViewAdapter extends BaseAdapter implements Filterable {
    TextView useridTextView;
    private TextView titleTextView;
    private ImageView iconImageView;
    private TextView contentTextView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<MListViewItem> listViewItemList = new ArrayList<MListViewItem>();
    public ArrayList<MListViewItem> filteredItemList = listViewItemList;
//    public ArrayList<String> OringinalItemList = OutputToFilter();


    //fragment transaction
//    private FragmentManager boardFragementManager;
//    private FragmentTransaction boardFragmentTranscation;


    //BoardListViewAdapter의 생성자
    public PostListViewAdapter(){
//        boardFragementManager = fm;
//        boardFragmentTranscation = ft;
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
    public View getView(final int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        //"board_listview_item" Layout을 infalte하여 convertView참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.post_listview_item,parent,false);

        }
        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        useridTextView = (TextView) convertView.findViewById(R.id.post_item_user_id);
        iconImageView = (ImageView) convertView.findViewById(R.id.post_item_icon);
        titleTextView = (TextView) convertView.findViewById(R.id.post_item_title);
        contentTextView = (TextView)convertView.findViewById(R.id.post_item_content2);
        useridTextView.setTextColor(Color.WHITE);
        contentTextView.setTextColor(Color.WHITE);


        final MListViewItem postlistViewItem = filteredItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        useridTextView.setText(postlistViewItem.getUser_id());
        titleTextView.setText(postlistViewItem.getTitle());
        iconImageView.setImageResource(postlistViewItem.getIcon());
        contentTextView.setText(postlistViewItem.getContent());
        titleTextView.setOnClickListener(new AdapterView.OnClickListener(){

            @Override
            public void onClick(View v) {
//                boardFragmentTranscation.commit();

            }
        });


        iconImageView.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });




        return convertView;

    }

    //아이템 데이터 추가를 위한 함수
    public void addItem(String user_id,String title,String content,int icon){
        MListViewItem item = new MListViewItem("","","","");



        item.setUser_id(user_id);
        item.setTitle(title);
//        item.setIcon(icon);
        item.setContent(content);
        item.setIcon(icon);
        listViewItemList.add(item);
    }

    @Override
    public Filter getFilter(){
        Filter g_filter = new Filter() {


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<MListViewItem> filteredArrList = new ArrayList<MListViewItem>();
                if(constraint == null || constraint.length()==0){
                    results.count = listViewItemList.size();
                    results.values = listViewItemList;

                }
                else{
                    constraint = constraint.toString().toLowerCase();
                    for(int i = 0 ; i < listViewItemList.size(); i++){
                        MListViewItem data = listViewItemList.get(i);
                        if(data.getContent().toLowerCase().contains(constraint.toString())){
                            filteredArrList.add(data);
                        }
                    }
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItemList = (ArrayList<MListViewItem>) results.values;
                notifyDataSetChanged();
            }
        };
        return g_filter;
    }

}
