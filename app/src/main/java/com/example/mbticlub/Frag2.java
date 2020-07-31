package com.example.mbticlub;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2,container,false);
        ArrayList<Integer> listImage = new ArrayList<>();
        listImage.add(R.drawable.cat);
        listImage.add(R.drawable.culture);
        listImage.add(R.drawable.lion);
        listImage.add(R.drawable.dog);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getFragmentManager());
        // ViewPager와  FragmentAdapter 연결
        viewPager.setAdapter(fragmentAdapter);

        viewPager.setClipToPadding(false);
        int dpValue = 16;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
        for (int i = 0; i < listImage.size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", listImage.get(i));
            imageFragment.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment);
        }
        fragmentAdapter.notifyDataSetChanged();
        /*for(i=0; i<listImage.size();i++){
            final int index;
            index = i;


        }*/
        ListView listview, listview2 ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listview1);


        listview.setAdapter(adapter);


        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(), R.drawable.ic_launcher),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(), R.drawable.ic_launcher),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(container.getContext(), R.drawable.ic_launcher),
                "Ind", "Assignment Ind Black 36dp") ;


        gridView = (GridView) view.findViewById(R.id.gridview);
        gridAdapter = new GridAdapter();



        gridAdapter.addItem(new GridItem("뮤지컬",R.drawable.poster));
        gridAdapter.addItem(new GridItem("영화",R.drawable.poster2));
        gridAdapter.addItem(new GridItem("조커",R.drawable.poster3));
        gridView.setAdapter(gridAdapter);

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        gridView.measure(0, expandSpec);
        gridView.getLayoutParams().height = gridView.getMeasuredHeight();

        return view;
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
