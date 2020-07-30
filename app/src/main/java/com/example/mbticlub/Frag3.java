package com.example.mbticlub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mbticlub.R;

import java.util.ArrayList;
import java.util.List;

public class Frag3 extends Fragment{


    private View view;
    private ListView board_list;
//    Button MBTI_selection;
//    TextView board_title;
    final CharSequence[] MBTIs = {"INTP","ENTP","INFP","ENFP","ESFP","ISFP"};
//    AlertDialog.Builder builder = new AlertDialog.Builder(null);



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);

//        MBTI_selection = (Button)view.findViewById(R.id.MBTI_selection);
//        board_title = (TextView)view.findViewById(R.id.board_title);



        board_list = (ListView) view.findViewById(R.id.board_list);

        List<String> board_data = new ArrayList<>();//arraylist 배열 안에 스트링 형태로 리스트를 만들겠다
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,board_data);
        board_list.setAdapter(adapter);

        board_data.add("여행");
        board_data.add("영화");
        board_data.add("질문과답변");
        board_data.add("연애");
        board_data.add("음악");
        board_data.add("운동");
        board_data.add("학업");
        board_data.add("소모임");
        board_data.add("자유");
        board_data.add("독서");






        adapter.notifyDataSetChanged();//이 상태를 저장

        //add data to listview
        ListView listView=new ListView(this.getActivity());
        //add data to array
        List<String> data=new ArrayList<>();
        data.add("INTJ");
        data.add("INTP");
        data.add("ENTJ");
        data.add("ENTP");

        data.add("INFj");
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
                dialog.dismiss();
            }
        });

        return view;
    }

}

