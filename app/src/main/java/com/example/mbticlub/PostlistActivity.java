package com.example.mbticlub;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostlistActivity extends AppCompatActivity {

    private View view;
    LinearLayout background;

    ListView post_listview;
    EditText post_editText_filter;
    int current_backgound;
    String current_board_title;

    //        -----------------
    Bundle receive_argu;

    ImageButton back_button;
    ImageButton add_button;
    Intent intent;
    Intent next_intent;
    ArrayList<MListViewItem> post_items= new ArrayList<>();



    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_listview);
        intent = getIntent();
//        view = inflater.inflate(R.layout.post_listview, container, false);
        background = findViewById(R.id.board_background);
        current_backgound = intent.getIntExtra("background", R.color.INTJ);


        final TextView text_board_title = findViewById(R.id.edit_post_BoardName);

        current_board_title = intent.getStringExtra("board_title");
        text_board_title.setText(intent.getStringExtra("board_title"));
        next_intent = new Intent(PostlistActivity.this, PostResister.class);
        next_intent.putExtra("board_title", intent.getStringExtra("board_title"));
//        if (getArguments() != null) {
//            current_backgound = getArguments().getInt("backgound");
//            board_title.setText(getArguments().getString("board_title"));
//
//        }
        back_button = findViewById(R.id.post_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Intent next_intent1 = new Intent(PostlistActivity.this, Frag3.class);
//                PostlistActivity.this.startActivity(next_intent1);
                onBackPressed();


            }
        });

        add_button = findViewById(R.id.post_add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostlistActivity.this.startActivity(next_intent);

            }
        });


        final PostListViewAdapter postlist_adapter = new PostListViewAdapter();
        post_listview = findViewById(R.id.post_listview);
        post_listview.setAdapter(postlist_adapter);
//        add_item(postlist_adapter);

        post_editText_filter = findViewById(R.id.post_textSearch);
        post_editText_filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                postlist_adapter.getFilter().filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




//        ------------------------ board_title

        //add data to listview

//        board_title.setText(receive_argu.getString("board_title"));

        background.setBackgroundResource(current_backgound);
//        clickLoad(view,postlist_adapter);
//        Toast.makeText(getApplicationContext(), current_board_title, Toast.LENGTH_SHORT).show();

//        PostlistRequest postlistRequest = new PostlistRequest(current_board_title, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
////                    Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
//
//                    JSONObject jsonObject = new JSONObject(response);
////                    Toast.makeText(getApplicationContext(), "했습니다", Toast.LENGTH_SHORT).show();
////                    JSONArray jsonArray=new JSONArray();
////                    jsonObject.toJSONArray(jsonArray);
////                    Toast.makeText(getApplicationContext(), jsonArray.getJSONObject(0).getString("post_user_id"), Toast.LENGTH_SHORT).show();
//
//                    JSONArray jsonArray = jsonObject.getJSONArray("jj");
//
//
//                    boolean success = jsonArray.getJSONObject(1).getBoolean("success");
//                    if(success) {
////                        Toast.makeText(getApplicationContext(), "성공했습니다", Toast.LENGTH_SHORT).show();
//
//                        for(int i = 0 ; i < jsonArray.length() ; i++){
//                            JSONObject j = jsonArray.getJSONObject(i);
//
//                            String post_user_id=j.getString("post_user_id");
//                            String post_title=j.getString("post_title");
//                            String post_content=j.getString("post_content");
//
//
////                            String board_title=jsonObject.getString("board_title");
//
//                            postlist_adapter.addItem(post_user_id,post_title,post_content,R.drawable.ic_baseline_person_24);
//                        }
//                        postlist_adapter.notifyDataSetChanged();
//                    }
//                    else{}
////                    Toast.makeText(getApplicationContext(), current_board_title, Toast.LENGTH_SHORT).show();
//
//                } catch (JSONException e) {
////                    Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();
//                }
//
//            }
//        });
//
//        RequestQueue queue = Volley.newRequestQueue(PostlistActivity.this);
//        queue.add(postlistRequest);


    }

    @Override
    protected void onResume() {
        super.onResume();
        current_board_title=next_intent.getStringExtra("board_title");
        current_backgound = next_intent.getIntExtra("background", R.color.INTJ);
//        Toast.makeText(getApplicationContext(), "다시", Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(), current_board_title, Toast.LENGTH_SHORT).show();

//        current_board_title = PreferenceManager.getString(getApplicationContext(),current_board_title);
        final PostListViewAdapter postlist_adapter = new PostListViewAdapter();
        post_listview = findViewById(R.id.post_listview);
        post_listview.setAdapter(postlist_adapter);

        PostlistRequest postlistRequest = new PostlistRequest(current_board_title, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
//                    Toast.makeText(getApplicationContext(), "했습니다", Toast.LENGTH_SHORT).show();
//                    JSONArray jsonArray=new JSONArray();
//                    jsonObject.toJSONArray(jsonArray);

                    JSONArray jsonArray = jsonObject.getJSONArray("jj");
//                    Toast.makeText(getApplicationContext(), jsonArray.getJSONObject(0).getString("post_user_id"), Toast.LENGTH_SHORT).show();


                    boolean success = jsonArray.getJSONObject(0).getBoolean("success");
                    if (success) {
//                        Toast.makeText(getApplicationContext(), "성공했습니다", Toast.LENGTH_SHORT).show();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j = jsonArray.getJSONObject(i);

                            String post_user_id = j.getString("post_user_id");
                            String post_title = j.getString("post_title");
                            String post_content = j.getString("post_content");


//                            String board_title=jsonObject.getString("board_title");

                            postlist_adapter.addItem(post_user_id, post_title, post_content, R.drawable.ic_baseline_person_24);
                        }
                        postlist_adapter.notifyDataSetChanged();
                    } else {
//                    Toast.makeText(getApplicationContext(), current_board_title, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        RequestQueue queue = Volley.newRequestQueue(PostlistActivity.this);
        queue.add(postlistRequest);
    }


}
