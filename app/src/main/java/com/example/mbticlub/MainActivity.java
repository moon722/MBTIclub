package com.example.mbticlub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView; // 하단바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;
    private ListView board_list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");


        //bottomNavigationView.setOnDragListener();
        bottomNavigationView=findViewById(R.id.bottomNavi); //객체생성 진행
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_bar_home:
                    setFrag(0);
                        break;
                    case R.id.action_bar_recommendation:
                        setFrag(1);
                        break;
                    case R.id.action_bar_board:
                        setFrag(2);
                        break;
                    case R.id.action_bar_notification:
                        setFrag(3);
                        break;
                    case R.id.action_bar_myInfo:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0); //첫 fragment화면을 무엇으로 지정할 것인지 선택(파라미터)
//        board_list = (ListView)findViewById(R.id.board_list);
    }
    //fragment 교체가 일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); // 실제적인 fragment교체가 이루어질때 frament를 가져와서 트랜잭션을 하려는 행위
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit(); // 보통 저장을 의미
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frag5);
                ft.commit();
                break;
        }
    }

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로 가기 버튼을 누를 때 표시
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // 기존 뒤로 가기 버튼의 기능을 막기 위해 주석 처리 또는 삭제

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지났으면 Toast 출력
        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            finish();
            toast.cancel();
            toast = Toast.makeText(this,"이용해 주셔서 감사합니다.",Toast.LENGTH_LONG);
            toast.show();
        }
    }

}