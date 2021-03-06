package com.example.mbticlub;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Frag3 extends Fragment{
    static Fragment postlist_frag;


    private View view;
    LinearLayout background;
    final CharSequence[] MBTIs = {"INTP","ENTP","INFP","ENFP","ESFP","ISFP"};


    //    -------------------board list,search
    ListView board_listview;
    EditText board_editText_filter;
    private static int current_backgound_param=R.color.INTP;
    //        -----------------

//    static Bundle arguments;
//    public static PostListFrag newInstance(){
//
//        PostListFrag fragment = new PostListFrag();
//        arguments = new Bundle();
//        arguments.putInt("backGround", getCurrent_backgound_param());
//        fragment.setArguments(arguments);
//        return fragment;
//    }

    public static int getCurrent_backgound_param() {
        return current_backgound_param;
    }

    public static void setCurrent_backgound_param(int current_backgound_param) {
        Frag3.current_backgound_param = current_backgound_param;
    }


    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3,container,false);
        background = view.findViewById(R.id.board_background);


//        Fragment frag4 = new Frag4();
//        postlist_frag = new PostListFrag();
//        arguments = new Bundle();
//        arguments.putInt("background",current_backgound_param);
//        postlist_frag.setArguments(arguments);
//        FragmentManager fm = new FragmentManager;
//        FragmentTransaction ft = getFragmentManager().beginTransaction();


//        ft.add(R.id.main_frame,postlist_frag);
//        ft.replace(R.id.main_frame,postlist_frag);




//        savedInstanceState.putInt("background",current_backgound);
//        transaction.commit();




        final Context context = container.getContext();


        final BoardListViewAdapter board_adapter=new BoardListViewAdapter(Frag3.this);
        board_listview = view.findViewById(R.id.board_listview);
        board_listview.setAdapter(board_adapter);
        add_item(board_adapter);
//        arguments.putString("board_title",board_adapter.board_name);

        board_editText_filter= view.findViewById(R.id.textSearch);
//        init_boardList();
//        board_listview.setTextFilterEnabled(board_adapter.getFilter()!=null);

        board_editText_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                board_adapter.getFilter().filter(s.toString());
//                board_listview.setFilterText(board_editText_filter.getText().toString());

            }
            @Override
            public void afterTextChanged(Editable s) {
//                String filterText = s.toString();
//                if(filterText.length()>0){
//                    board_listview.setFilterText(filterText);
////                    Toast.makeText(context,filterText,Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    board_listview.clearTextFilter();
//                }
//                if(board_editText.getText().length()==0){
//                    board_listview.clearTextFilter();
//                }

            }
        });
//        ------------------------ mbti button

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

        final EditText txtDate = view.findViewById(R.id.editMBTI);
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
                setCurrent_backgound_param(board_colors[position]);
                background.setBackgroundResource(getCurrent_backgound_param());

                dialog.dismiss();
            }
        });
        background.setBackgroundResource(getCurrent_backgound_param());

//        -----------------
//        Fragment newFragement = new Frag4();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_frame,newFragement);
//        transaction.addToBackStack(null);
//        transaction.commit();



        return view;
    }

    public void add_item(BoardListViewAdapter board_adapter){
        String[] board_items=new String[]{"All","Anything","Travel","Relationship","Video game","Sports","Films","Books","Meet-up"};
        for(String item:board_items){
            board_adapter.addItem(item,R.drawable.ic_baseline_star_border_24);
        }

        board_adapter.notifyDataSetChanged();


    }
    //상태를 저장하기 위한 부분
    //장비의 설정 상태 변경, 화면 방향 변경등의 변화에 의해 프래그먼트가 정지될떄 호출
    public void OnSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("backGround", getCurrent_backgound_param());
    }
//    public interface OnApplySelectedListner{
//        public void onCatagoryApplySelected(int background, String board_title);
//    }

}