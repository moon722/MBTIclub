package com.example.mbticlub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.tabs.TabLayout;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;


public class Frag1 extends Fragment {

    private View view;
    //변수 선언
    private ArrayList<Integer> imageList;//이미지 객체배열
    private static final int DP = 10;//마진 조정
    private ListView listView;
    private ListViewAdapter1 adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1,container,false);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getFragmentManager());

        this.initializeData(fragmentAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // ViewPager vp = (ViewPager) view.findViewById(R.id.ImageMain1);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager());

        this.initializeData(fragmentAdapter);
    }


    public void initializeData(FragmentAdapter fragmentAdapter)
    {

        imageList = new ArrayList();

        imageList.add(R.drawable.movie1);
        imageList.add(R.drawable.movie2);
        imageList.add(R.drawable.movie3);

        adapter = new ListViewAdapter1();

        adapter.addItem(R.drawable.fire,"HOT Board");
        adapter.addItem(R.drawable.ic_baseline_turned_in_24,"Favorites");
        adapter.addItem(R.drawable.sysinfo,"Tip Board");
        adapter.notifyDataSetChanged();

        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent;
//                switch (position){
//                    case 0: intent = new Intent(getActivity(),hotListview.class);
//                    break;
//                    case 1: intent = new Intent(getActivity(),Favorite_list.class);
//                    break;
//                    case 2: intent = new Intent(getActivity(),infoList.class);
//                    break;
//                    default:
//                        intent = null;
//                        break;
//                }
//                startActivity(intent);
//            }
//        });


        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);

        ViewPager viewPager = view.findViewById(R.id.ImageMain1);

        viewPager.setAdapter(fragmentAdapter);
        viewPager.setClipToPadding(false);

        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        //viewPager.setAdapter(new ImageFragment(this, imageList));


        for(int i = 0; i<imageList.size(); i++){
            ImageFragment1 imageFragment1 = new ImageFragment1();
            Bundle bundle = new Bundle();
            bundle.putInt("imgRes", imageList.get(i));
            imageFragment1.setArguments(bundle);
            fragmentAdapter.addItem(imageFragment1);
        }
        fragmentAdapter.notifyDataSetChanged();

    }

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
}