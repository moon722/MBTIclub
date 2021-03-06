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

public class FragCoin extends AppCompatActivity {
    CoinAdapter adapter;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag5_coin);
        getIntent();

        ListView listView = (ListView) findViewById(R.id.coin_list);

        // 어댑터 안에 데이터 담기
        adapter = new CoinAdapter();

        adapter.addItem(new CoinItem("Get Free Coin", "Free", R.drawable.freecoin));
        adapter.addItem(new CoinItem("50 Coin", "₩3000", R.drawable.fiftycoin));
        adapter.addItem(new CoinItem("100 Coin", "₩5000", R.drawable.onehundredcoin));
        adapter.addItem(new CoinItem("220 Coin", "₩10000", R.drawable.twocoin));

        // 리스트 뷰에 어댑터 설정
        listView.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CoinItem item = (CoinItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class CoinAdapter extends BaseAdapter {
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
            CoinItemView view = null;
            if (convertView == null) {
                view = new CoinItemView(getApplicationContext());
            } else {
                view = (CoinItemView) convertView;
            }

            CoinItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }
}