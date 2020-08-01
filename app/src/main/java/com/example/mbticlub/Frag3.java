package com.example.mbticlub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mbticlub.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Frag3 extends Fragment{


    private View view;
    LinearLayout background;
    final CharSequence[] MBTIs = {"INTP","ENTP","INFP","ENFP","ESFP","ISFP"};


//    -------------------board list,search
    String[] board_items;
    ArrayList<String> board_listitems;
    ArrayAdapter<String> board_adapter;
    ListView board_listview;
    EditText board_editText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);
        background = (LinearLayout)view.findViewById(R.id.board_background);

        board_listview = (ListView)view.findViewById(R.id.board_listview);
        board_editText=(EditText)view.findViewById(R.id.textSearch);
        init_boardList();
        board_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    //reset listview
                    init_boardList();
                }
                else{
                    //perform search
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //add data to listview
        ListView listView=new ListView(this.getActivity());
        //add data to array
        List<String> data=new ArrayList<>();
        data.add("INTJ");
        data.add("INTP");
        data.add("ENTJ");
        data.add("ENTP");

        data.add("INFJ");
        data.add("INFP");
        data.add("ENFJ");
        data.add("ENFP");

        data.add("ISTJ");
        data.add("INFJ");
        data.add("ESTJ");
        data.add("ESFJ");

        data.add("ISTP");
        data.add("ISFP");
        data.add("ESTP");
        data.add("ESFP");
        final int[] board_colors = {R.color.INTJ,R.color.INTP,R.color.ENTJ,R.color.ENTP,
                R.color.INFJ,R.color.INFP,R.color.ENFJ,R.color.ENFP,
                R.color.ISTJ,R.color.INFJ,R.color.ESTJ,R.color.ESFJ,
                R.color.ISTP,R.color.ISFP,R.color.ESTP,R.color.ESFP};



        //create array adapter
        final ArrayAdapter<String> adapter_dialog=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter_dialog);
        //now we add list view to alert box
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialog = builder.create();
        //do action to Edit Text
        final EditText txtDate = (EditText)view.findViewById(R.id.editMBTI);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtDate.setText(adapter_dialog.getItem(position));
                background.setBackgroundResource(board_colors[position]);

                dialog.dismiss();
            }
        });

        return view;
    }
    public void searchItem(String textToSearch){
        for(String item:board_items){
            if(!item.contains(textToSearch)){
                board_listitems.remove(item);
            }

            board_adapter.notifyDataSetChanged();
        }

    }
    public void init_boardList(){
        board_items=new String[]{"Full board","travel","date","game","exercise","cooking"};
        board_listitems=new ArrayList<>(Arrays.asList(board_items));
        board_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,board_listitems);
        board_listview.setAdapter(board_adapter);
    }

}