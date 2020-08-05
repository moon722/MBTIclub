package com.example.mbticlub;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FragSubscribe extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    ListView listview;
    SubscribeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag5_my_subscribes);


        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.my_subscribes_list);
        listview.setAdapter(adapter);
        getIntent();

        // 어댑터 안에 데이터 담기
        adapter = new FragSubscribe.SubscribeAdapter();

        adapter.addItem(new CoinItem("August week 1st 2020 ", "2020 Films to Recommend to People of ENTP Type", R.drawable.movieaward));
        adapter.addItem(new CoinItem("July week 4th 2020 ", "MBTI Type Specific Study Method", R.drawable.study));
        adapter.addItem(new CoinItem("July week 3th 2020 ", "Characteristics of MBTI type in relation to views on life", R.drawable.mbtiform));
        adapter.addItem(new CoinItem("July week 2nd 2020 ", "How your MBTI influence your income", R.drawable.mbtiincome));

        // 리스트 뷰에 어댑터 설정
        listview.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CoinItem item = (CoinItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class SubscribeAdapter extends BaseAdapter {
        ArrayList<CoinItem> items = new ArrayList<CoinItem>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CoinItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            Subscribe view = null;
            if (convertView == null) {
                view = new Subscribe(getApplicationContext());
            } else {
                view = (Subscribe) convertView;
            }

            CoinItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }
}
