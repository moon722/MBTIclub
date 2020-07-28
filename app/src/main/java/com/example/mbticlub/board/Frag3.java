package com.example.mbticlub.board;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mbticlub.R;

import java.util.ArrayList;
import java.util.List;

public class Frag3 extends Fragment {


    private View view;
    private ListView board_list;
    Button MBTI_selection;
    TextView board_title;
    final CharSequence[] MBTIs = {"INTP","ENTP","INFP","ENFP","ESFP","ISFP"};
//    AlertDialog.Builder builder = new AlertDialog.Builder(null);




    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag3);


        button8.setOnClickListener { view ->

                var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            //리스너 세팅
            //리스트뷰 다이얼로그의 몇번째 항목을 선택했는지가 which에 들어옴
            //버튼들에 세팅하면 이게 몇번째 버튼인지/setItems에 세팅하면 이게 몇번째 항목인지가 들어옴.옴
            var listner =  object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    textView.text = "기본리스트 다이얼로그 :  ${data1[which]}"
                }
            }
            builder.setItems(data1, listner)
            builder.show()

        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);

        MBTI_selection = (Button)view.findViewById(R.id.MBTI_selection);
        board_title = (TextView)view.findViewById(R.id.board_title);



        board_list = (ListView) view.findViewById(R.id.board_list);


        List<String> board_data = new ArrayList<>();//arraylist 배열 안에 스트링 형태로 리스트를 만들겠다
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,board_data);


        board_list.setAdapter(adapter);

        board_data.add("여행");
        board_data.add("영화");
        board_data.add("질문과답변");

        adapter.notifyDataSetChanged();//이 상태를 저장

        return view;
    }
}
