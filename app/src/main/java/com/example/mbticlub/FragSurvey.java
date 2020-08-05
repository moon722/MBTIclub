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

public class FragSurvey extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    ListView listview;
    SurveyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag5_survey);
        getIntent();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.survey_list);
        listview.setAdapter(adapter);
        getIntent();

        // 어댑터 안에 데이터 담기
        adapter = new SurveyAdapter();

        adapter.addItem(new SurveyItem("(Movie) Iron Man" ,"Director : Jon favreau", R.drawable.ironman1, R.drawable.goodevaluation));
        adapter.addItem(new SurveyItem("(Movie) Parasite ", "Director : Bong Joon-ho", R.drawable.parasite, R.drawable.goodevaluation));
        adapter.addItem(new SurveyItem("(Book) Animal Farm ", "Writer : George Orwell", R.drawable.animalfarm, R.drawable.badevaluation));
        adapter.addItem(new SurveyItem("(Music) Havana ", "Singer : Camila Cabello", R.drawable.havana, R.drawable.goodevaluation));

        // 리스트 뷰에 어댑터 설정
        listview.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SurveyItem item = (SurveyItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class SurveyAdapter extends BaseAdapter {
        ArrayList<SurveyItem> items = new ArrayList<SurveyItem>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SurveyItem item) {
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
            Survey view = null;
            if (convertView == null) {
                view = new Survey(getApplicationContext());
            } else {
                view = (Survey) convertView;
            }

            SurveyItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());
            view.setImageView2(item.getEvlaution());

            return view;
        }
    }
}
