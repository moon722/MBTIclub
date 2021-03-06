package com.example.mbticlub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
//대신 ListVewItemAdapter 써볼것

public class BoardListViewAdapter extends BaseAdapter implements Filterable {
    private TextView titleTextView;
    private ImageView iconImageView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<MListViewItem> listViewItemList = new ArrayList<MListViewItem>();
    public ArrayList<MListViewItem> filteredItemList = listViewItemList;
    public ArrayList<String> OringinalItemList = OutputToFilter();

    public String board_name;

    //fragment transaction
    private FragmentManager boardFragementManager;
    private FragmentTransaction boardFragmentTranscation;
    private FragmentActivity boardFragmentActivity;

    private Frag3 fragment;
    Intent intent;



    //BoardListViewAdapter의 생성자
    public BoardListViewAdapter(Frag3 frag3){
        boardFragementManager = frag3.getFragmentManager();
        boardFragmentTranscation = boardFragementManager.beginTransaction();
//        intent  = new Intent(frag3.getActivity(),PostlistActivity());
        this.fragment = frag3;

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
            convertView=inflater.inflate(R.layout.board_listview_item,parent,false);

        }
        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        titleTextView= convertView.findViewById(R.id.board_item_title);
        iconImageView = convertView.findViewById(R.id.board_item_icon);


        final MListViewItem boardlistViewItem = filteredItemList.get(position);
        intent = new Intent(fragment.getActivity(),PostlistActivity.class);


        //아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(boardlistViewItem.getTitle());
        iconImageView.setImageResource(boardlistViewItem.getIcon());
//        contentTextView.setText(listViewItem.getDesc());
        titleTextView.setOnClickListener(new AdapterView.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("backgound",Frag3.getCurrent_backgound_param());
//                bundle.putString("board_title",boardlistViewItem.getTitle());
//                Frag3.postlist_frag.setArguments(bundle);
////                Frag3.newInstance();
//                boardFragmentTranscation.replace(R.id.main_frame,Frag3.postlist_frag);
//                notifyDataSetChanged();
////                boardFragmentTranscation.addToBackStack(null);
//                boardFragmentTranscation.commit();
                intent.putExtra("background", Frag3.getCurrent_backgound_param());
                intent.putExtra("board_title",boardlistViewItem.getTitle());
                PreferenceManager.setString(context,"current_board_title",boardlistViewItem.getTitle());

                fragment.getActivity().startActivity(intent);



            }
        });

        iconImageView.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(boardlistViewItem.getIcon()==R.drawable.ic_baseline_star_border_24){
                    filteredItemList.get(position).setIcon(R.drawable.ic_baseline_star_24);

//                    BoardListViewItem b =new BoardListViewItem();
//                    b.setTitle(boardlistViewItem.getTitle());
//                    b.setIcon(R.drawable.ic_baseline_star_24);
//                    filteredItemList.add(0,b);
//                    filteredItemList.remove(boardlistViewItem);
                    notifyDataSetChanged();
                }
                else{
//                    BoardListViewItem b =new BoardListViewItem();
//                    b.setTitle(boardlistViewItem.getTitle());
//                    b.setIcon(R.drawable.ic_baseline_star_border_24);
//                    filteredItemList.remove(boardlistViewItem);
//                    filteredItemList.add(,b);
                    filteredItemList.get(position).setIcon(R.drawable.ic_baseline_star_border_24);
                    notifyDataSetChanged();


                }
            }

        });




        return convertView;

    }
    public void TurnBookmark(){

    }
    //아이템 데이터 추가를 위한 함수
    public void addItem(String title, int icon){
        MListViewItem item = new MListViewItem("","","","");


        item.setTitle(title);
        item.setIcon(icon);
//        item.setDesc(content);
        listViewItemList.add(item);
    }
    public ArrayList<String> OutputToFilter(){
        ArrayList<String> board_title_list = new ArrayList<String>();
        for(MListViewItem B : listViewItemList){
            board_title_list.add(B.getTitle());
        }
        return board_title_list;
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
                        if(data.getTitle().toLowerCase().contains(constraint.toString())){
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
