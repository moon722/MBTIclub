package com.example.mbticlub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    private TextView NameTestView;
    private ImageView IconImageView;
    private TextView CommentTextView;

    public ArrayList<ChatItem> listViewItemList = new ArrayList<ChatItem>();
//    public ArrayList<ChatItem> filteredItemList = listViewItemList;

    public CommentAdapter(){

    }

//    public CommentAdapter(TextView nameTestView, ImageView iconImageView, TextView commentTextView) {
//        NameTestView = nameTestView;
//        IconImageView = iconImageView;
//        CommentTextView = commentTextView;
//    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.comment_list,parent,false);
        }

        NameTestView = convertView.findViewById(R.id.comment_list_nam);
        IconImageView = convertView.findViewById(R.id.comment_list_Igv);
        CommentTextView = convertView.findViewById(R.id.comment_list_con);

        final ChatItem chatItem = listViewItemList.get(position);

        NameTestView.setText(chatItem.getTitle());
        IconImageView.setImageResource(chatItem.getIcon());
        CommentTextView.setText(chatItem.getDesc());


        return convertView;
    }

    public void addItem(String Name, int Image,String comment){
        ChatItem item = new ChatItem();

        item.setTitle(Name);
        item.setIcon(Image);
        item.setDesc(comment);
        listViewItemList.add(item);
    }
}
