package com.example.mbticlub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Matching extends AppCompatActivity {

    private ListAdapter MatchingListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        MatchingViewpagerAdapter MatchingpagerAdapter = new MatchingViewpagerAdapter(getSupportFragmentManager());

        // ViewPager와  FragmentAdapter 연결
        ViewPager viewPager = findViewById(R.id.izviewPager);
        viewPager.setAdapter(MatchingpagerAdapter);
        viewPager.setClipToPadding(false);


        ArrayList<Integer> listImage = new ArrayList<>();

        listImage.add(R.drawable.recommend);
        listImage.add(R.drawable.select_friend);
        listImage.add(R.drawable.region);

        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
        for (int i = 0; i < listImage.size(); i++) {
            ImageFragment2 imageFragment = new ImageFragment2();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            MatchingpagerAdapter.addItem(imageFragment);
        }
        MatchingpagerAdapter.notifyDataSetChanged();

        String[] match_title1=new String[]{"Gender","Age"};
        ListView matchListView = findViewById(R.id.matching_listview);
        MatchingListViewAdapter match_adapter = new MatchingListViewAdapter();
        matchListView.setAdapter(match_adapter);
        for(String item:match_title1){
            match_adapter.addItem(item,"선택");

        }
        match_adapter.notifyDataSetChanged();
        String[] title = new String[]{"Recommend", "Custom","Location"};
        TextView match_ti = findViewById(R.id.match_title_text);
        match_ti.setText(title[0]);






        int view_position = viewPager.getCurrentItem();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("viewposition",position+" ");

                String[] match_title1=new String[]{"Gender","Age"};
                String[] match_title2=new String[]{"Gender","Age","MBTI","Interest"};
                String[] match_title3=new String[]{"Gender","Age","Location"};
                ListView matchListView = findViewById(R.id.matching_listview);
                MatchingListViewAdapter match_adapter = new MatchingListViewAdapter();
                matchListView.setAdapter(match_adapter);

                String[] title = new String[]{"Recommend", "Custom","Location"};
                TextView match_ti = findViewById(R.id.match_title_text);

                switch (position){
                    case 0:
                        match_ti.setText(title[0]);
                        for(String item:match_title1){
                            match_adapter.addItem(item,"선택");

                        }
                        match_adapter.notifyDataSetChanged();
                        break;

                    case 1:
                        match_ti.setText(title[1]);

                        for(String item:match_title2){
                            match_adapter.addItem(item,"선택");
                        }
                        match_adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        match_ti.setText(title[2]);

                        for(String item:match_title3){
                            match_adapter.addItem(item,"선택");
                        }
                        match_adapter.notifyDataSetChanged();
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



//        String[] match_items=new String[]{"All","Anything","Travel","Relationship","Video game","Sports","Films","Books","Meet-up"};
//        for(String item:match_items){
//            match_adapter.addItem(item,"흠");
//        }

//        match_adapter.notifyDataSetChanged();



    }
}

class MatchingViewpagerAdapter extends FragmentPagerAdapter {

    // ViewPager에 들어갈 Fragment들을 담을 리스트
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // 필수 생성자
    MatchingViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    // List에 Fragment를 담을 함수
    void addItem(Fragment fragment) {
        fragments.add(fragment);
    }

}


class MatchingListViewAdapter extends BaseAdapter {
    private TextView titleTextView;
    private TextView optionTextView;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<MatchingViewItem> filteredItemList = new ArrayList<>();

    //fragment transaction
    private FragmentManager boardFragementManager;
    private FragmentTransaction boardFragmentTranscation;
    private FragmentActivity boardFragmentActivity;

    //BoardListViewAdapter의 생성자
    public MatchingListViewAdapter(){


    }

    //Adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount(){
        return filteredItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.matching_listview_item,parent,false);

        }
        //add data to listview
        ListView listView = new ListView(parent.getContext());
        //add data to array
        List<String> age=new ArrayList<>();
        age.add("15~20");
        age.add("20~25");
        age.add("25~30");

        List<String> gender = new ArrayList<>();

        gender.add("female");
        gender.add("male");

        List<String> mbti = new  ArrayList<>();

        mbti.add("ENFP");
        mbti.add("ENFJ");

        mbti.add("ISTJ");
        mbti.add("INFJ");
        mbti.add("ESTJ");
        mbti.add("ESFJ");

        mbti.add("ISTP");
        mbti.add("ISFP");
        mbti.add("ESTP");
        mbti.add("ESFP");

        List<String> interest = new ArrayList<>();
        interest.add("book");
        interest.add("movie");
        interest.add("travel");
        interest.add("game");
        interest.add("food");
        List<String> location = new ArrayList<>();
        location.add("Seoul");
        location.add("Gyeonggi-do");
        location.add("Chungcheongnam-do");
        location.add("Daegu");



        final int[] board_colors = {R.color.INTJ,R.color.INTP,R.color.ENTJ,R.color.ENTP,
                R.color.INFJ,R.color.INFP,R.color.ENFJ,R.color.ENFP,
                R.color.ISTJ,R.color.INFJ,R.color.ESTJ,R.color.ESFJ,
                R.color.ISTP,R.color.ISFP,R.color.ESTP,R.color.ESFP};
        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        titleTextView= convertView.findViewById(R.id.matching_item_title);
        optionTextView = convertView.findViewById(R.id.matching_item_option);

        final MatchingViewItem matchingViewItem = filteredItemList.get(position);


        //아이템 내 각 위젯에 데이터 반영
        titleTextView.setText(matchingViewItem.getTitle());
        optionTextView.setText(matchingViewItem.getContent());
//        Toast.makeText(context, matchingViewItem.getTitle(), Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();


        List<String> result;
        //create array adapter
        if(matchingViewItem.getTitle() == "Gender"){
            result = gender;
        }
        else if(matchingViewItem.getTitle() == "Age"){
            result = age;
        }
        else if(matchingViewItem.getTitle() == "MBTI"){
            result = mbti;
        }
        else if(matchingViewItem.getTitle() == "Interest"){
            result = interest;
        }
        else{
            result = location;
        }
        final ArrayAdapter<String> adapter_dialog=new ArrayAdapter<String>(parent.getContext(),android.R.layout.simple_list_item_1,result);
        listView.setAdapter(adapter_dialog);
        //now we add list view to alert box
        AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialog = builder.create();
        //do action to Edit Text

        optionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                matchingViewItem.setContent(adapter_dialog.getItem(position));
//                optionTextView.setText(matchingViewItem.getContent());

                dialog.dismiss();
                notifyDataSetChanged();
            }
        });
        notifyDataSetChanged();


        return convertView;

    }

    //아이템 데이터 추가를 위한 함수
    public void addItem(String title, String content){
        MatchingViewItem item = new MatchingViewItem("","");


        item.setTitle(title);
        item.setContent(content);
//        item.setDesc(content);
        filteredItemList.add(item);
    }

}




