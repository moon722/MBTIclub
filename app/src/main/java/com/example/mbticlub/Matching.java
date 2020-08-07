//package com.example.mbticlub;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.viewpager.widget.ViewPager;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Matching extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_matching);
//        MatchingViewpagerAdapter MatchingAdapter = new MatchingViewpagerAdapter(getSupportFragmentManager());
//
//        // ViewPager와  FragmentAdapter 연결
//        ViewPager viewPager = findViewById(R.id.izviewPager);
//        viewPager.setAdapter(MatchingAdapter);
//        viewPager.setClipToPadding(false);
//
//        int dpValue = 16;
//        float d = getResources().getDisplayMetrics().density;
//        int margin = (int) (dpValue * d);
//        viewPager.setPadding(margin, 0, margin, 0);
//        viewPager.setPageMargin(margin / 2);
//
//        ArrayList<Integer> listImage = new ArrayList<>();
//
//        listImage.add(R.drawable.content1);
//        listImage.add(R.drawable.content2);
//        listImage.add(R.drawable.content3);
//
//        // FragmentAdapter에 Fragment 추가, Image 개수만큼 추가
//        for (int i = 0; i < listImage.size(); i++) {
//            ImageFragment imageFragment = new ImageFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt("imgRes", listImage.get(i));
//            imageFragment.setArguments(bundle);
//            MatchingAdapter.addItem(imageFragment);
//        }
//        MatchingAdapter.notifyDataSetChanged();
//    }
//}
//class MatchingViewpagerAdapter extends FragmentPagerAdapter {
//
//    // ViewPager에 들어갈 Fragment들을 담을 리스트
//    private ArrayList<Fragment> fragments = new ArrayList<>();
//
//    // 필수 생성자
//    MatchingViewpagerAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return fragments.get(position);
//    }
//
//    @Override
//    public int getCount() {
//        return fragments.size();
//    }
//
//    // List에 Fragment를 담을 함수
//    void addItem(Fragment fragment) {
//        fragments.add(fragment);
//    }
//
//}
//
//
//public class MachingViewItem {
//    private String title;
//    private String content;
//
//
//    public MachingViewItem(int image, String sex, String age,String mbti, String interest,String region, String content) {
//        this.image = image;
//        this.sex = sex;
//        this.age = age;
//        this.mbti = mbti;
//        this.interest = interest;
//        this.region = region;
//
//    }
//
//    public void setUser_id(String user_id){this.user_id = user_id;}
//    public void setIcon(int icon) {
//        this.icon = icon ;
//    }
//    public void setTitle(String title) {
//        this.title = title ;
//    }
//    public void setContent(String content) {
//        this.content = content ;
//    }
//    public void setBoard_title(String board_title) {
//        this.board_title = board_title ;
//    }
//
//
//    public int getIcon() {
//        return this.icon ;
//    }
//    public String getTitle() {
//        return this.title ;
//    }
//
//    public String getContent() {
//        return this.content ;
//    }
//    public String getUser_id(){ return this.user_id;}
//    public String getBoard_title(){ return this.board_title;}
//
//
//}
//public class MatchingListViewAdapter extends BaseAdapter {
//    private TextView titleTextView;
//    private EditText optionTextView;
//
//    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
//    public ArrayList<String> listViewItemList = new ArrayList<String>();
//    public ArrayList<String> filteredItemList = listViewItemList;
//
//    //fragment transaction
//    private FragmentManager boardFragementManager;
//    private FragmentTransaction boardFragmentTranscation;
//    private FragmentActivity boardFragmentActivity;
//
//    //BoardListViewAdapter의 생성자
//    public MatchingListViewAdapter(){
//
//
//    }
//
//    //Adapter에 사용되는 데이터의 개수를 리턴
//    @Override
//    public int getCount(){
//        return filteredItemList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return filteredItemList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴
//    @Override
//    public View getView(final int position, View convertView, final ViewGroup parent){
//        //add data to listview
//        ListView listView=new ListView();
//        //add data to array
//        List<String> age=new ArrayList<>();
//        age.add("15~20");
//        age.add("20~25");
//        age.add("25~30");
//
//        List<String> sex = new ArrayList<>();
//
//        sex.add("female");
//        sex.add("male");
//
//        List<String> mbti = new
//
//        data.add("ENFP");
//        data.add("ENFJ");
//
//        data.add("ISTJ");
//        data.add("INFJ");
//        data.add("ESTJ");
//        data.add("ESFJ");
//
//        data.add("ISTP");
//        data.add("ISFP");
//        data.add("ESTP");
//        data.add("ESFP");
//        final int[] board_colors = {R.color.INTJ,R.color.INTP,R.color.ENTJ,R.color.ENTP,
//                R.color.INFJ,R.color.INFP,R.color.ENFJ,R.color.ENFP,
//                R.color.ISTJ,R.color.INFJ,R.color.ESTJ,R.color.ESFJ,
//                R.color.ISTP,R.color.ISFP,R.color.ESTP,R.color.ESFP};
//
//
//
//        //create array adapter
//        final ArrayAdapter<String> adapter_dialog=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter_dialog);
//        //now we add list view to alert box
//        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//        builder.setCancelable(true);
//        builder.setView(listView);
//        final AlertDialog dialog = builder.create();
//        //do action to Edit Text
//
//        final EditText txtDate = view.findViewById(R.id.);
//        txtDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.show();
//            }
//        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                txtDate.setText(adapter_dialog.getItem(position));
//
//                dialog.dismiss();
//            }
//        });
//        background.setBackgroundResource(getCurrent_backgound_param());
//        final int pos = position;
//        final Context context = parent.getContext();
//
//        //"board_listview_item" Layout을 infalte하여 convertView참조 획득
//        if(convertView == null){
//            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView=inflater.inflate(R.layout.board_listview_item,parent,false);
//
//        }
//        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
//        titleTextView= convertView.findViewById(R.id.board_item_title);
//        iconImageView = convertView.findViewById(R.id.board_item_icon);
//
//
//        final MListViewItem boardlistViewItem = filteredItemList.get(position);
//        intent = new Intent(fragment.getActivity(),PostlistActivity.class);
//
//
//        //아이템 내 각 위젯에 데이터 반영
//        titleTextView.setText(boardlistViewItem.getTitle());
//        iconImageView.setImageResource(boardlistViewItem.getIcon());
////        contentTextView.setText(listViewItem.getDesc());
//        titleTextView.setOnClickListener(new AdapterView.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//                intent.putExtra("background", Frag3.getCurrent_backgound_param());
//                intent.putExtra("board_title",boardlistViewItem.getTitle());
//                PreferenceManager.setString(context,"current_board_title",boardlistViewItem.getTitle());
//
//                fragment.getActivity().startActivity(intent);
//
//
//
//            }
//        });
//
//        iconImageView.setOnClickListener(new AdapterView.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                if(boardlistViewItem.getIcon()==R.drawable.ic_baseline_star_border_24){
//                    filteredItemList.get(position).setIcon(R.drawable.ic_baseline_star_24);
//
//                    notifyDataSetChanged();
//                }
//                else{
//
//                    filteredItemList.get(position).setIcon(R.drawable.ic_baseline_star_border_24);
//                    notifyDataSetChanged();
//
//
//                }
//            }
//
//        });
//
//
//
//
//        return convertView;
//
//    }
//
//    //아이템 데이터 추가를 위한 함수
//    public void addItem(String title, int icon){
//        MListViewItem item = new MListViewItem("","","","");
//
//
//        item.setTitle(title);
//        item.setIcon(icon);
////        item.setDesc(content);
//        listViewItemList.add(item);
//    }
//    public ArrayList<String> OutputToFilter(){
//        ArrayList<String> board_title_list = new ArrayList<String>();
//        for(MListViewItem B : listViewItemList){
//            board_title_list.add(B.getTitle());
//        }
//        return board_title_list;
//    }
//
//}
//
//
//
//
