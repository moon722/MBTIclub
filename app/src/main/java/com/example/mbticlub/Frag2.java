package com.example.mbticlub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Frag2 extends Fragment {

    private View view;
    GridView gridView;
    GridAdapter gridAdapter;
    TextView quest;
    ListView listview;
    ListViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2,container,false);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getFragmentManager());
        init(fragmentAdapter);

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listview1);
        gridView = (GridView) view.findViewById(R.id.gridview);
        quest = (TextView)view.findViewById(R.id.quest);

        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(),R.drawable.movie1),"Liked this movie?", "Parasite") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(), R.drawable.exhibition1),
                "Liked this exhibition?", "Hands on the Table") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(), R.drawable.game1),
                "Liked this game?", "BattleGround") ;
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        listview.measure(0, expandSpec);
        listview.getLayoutParams().height = listview.getMeasuredHeight();


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                startActivity(intent);
            }
        });



        gridAdapter = new GridAdapter();


        gridAdapter.addItem(new GridItem("Musical",R.drawable.poster));
        gridAdapter.addItem(new GridItem("Movie",R.drawable.poster2));
        gridAdapter.addItem(new GridItem("Movie",R.drawable.poster3));
        gridView.setAdapter(gridAdapter);

        gridView.measure(0, expandSpec);
        gridView.getLayoutParams().height = gridView.getMeasuredHeight();

        quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionActivity.class);
                startActivity(intent);

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        init(fragmentAdapter);
    }

    public void init(FragmentAdapter fragmentAdapter){
        // ViewPager와  FragmentAdapter 연결
        ViewPager viewPager = view.findViewById(R.id.hrviewPager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setClipToPadding(false);

        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        ArrayList<Integer> listImage = new ArrayList<>();

        listImage.add(R.drawable.content1);
        listImage.add(R.drawable.content2);
        listImage.add(R.drawable.content3);

        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
        for (int i = 0; i < listImage.size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }
        fragmentAdapter.notifyDataSetChanged();


    }


    class FragmentAdapter extends FragmentPagerAdapter {

        // ViewPager에 들어갈 Fragment들을 담을 리스트
        private ArrayList<Fragment> fragments = new ArrayList<>();

        // 필수 생성자
        FragmentAdapter(FragmentManager fm) {
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

    }class GridAdapter extends BaseAdapter{
        ArrayList<GridItem> items = new ArrayList<GridItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(GridItem singerItem){
            items.add(singerItem);
        }

        @Override
        public GridItem getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            GridViewer singerViewer = new GridViewer(viewGroup.getContext());
            singerViewer.setItem(items.get(i));
            return singerViewer;
        }
    }





}