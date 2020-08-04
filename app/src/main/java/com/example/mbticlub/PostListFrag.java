//package com.example.mbticlub;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PostListActivity extends AppCompatActivity {
//
//    private View view;
//    LinearLayout background;
//
//    ListView post_listview;
//    EditText post_editText_filter;
//    int current_backgound;
//
//    //        -----------------
//    Bundle receive_argu;
//
//    ImageButton back_button;
//
//
//
//    @Nullable
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.post_listview);
////        view = inflater.inflate(R.layout.post_listview, container, false);
//        background = findViewById(R.id.board_background);
//        final TextView board_title = view.findViewById(R.id.edit_post_BoardName);
////        if (getArguments() != null) {
////            current_backgound = getArguments().getInt("backgound");
////            board_title.setText(getArguments().getString("board_title"));
////
////        }
//        back_button = findViewById(R.id.post_back_button);
//        back_button.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//
//        final PostListViewAdapter postlist_adapter = new PostListViewAdapter();
//        post_listview = view.findViewById(R.id.post_listview);
//        post_listview.setAdapter(postlist_adapter);
//        add_item(postlist_adapter);
//
//        post_editText_filter = view.findViewById(R.id.post_textSearch);
//        post_editText_filter.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                postlist_adapter.getFilter().filter(s.toString());
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
////        ------------------------ board_title
//
//        //add data to listview
//
////        board_title.setText(receive_argu.getString("board_title"));
//
//        background.setBackgroundResource(current_backgound);
//
//
//    }
//
//    public void add_item(PostListViewAdapter postlist_adapter){
//        String[] post_content=new String[]{"전체게시판","자유게시판","여행","연애","게임","운동","영화","독서","소모임"};
//        for(String item:post_content){
//            postlist_adapter.addItem("익명",R.drawable.ic_baseline_person_24,item);
//        }
//
//        postlist_adapter.notifyDataSetChanged();
//    }
//
//
//}
