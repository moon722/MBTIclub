package com.example.mbticlub;



import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionActivity extends AppCompatActivity {
    ImageView questimg;
    TextView questtitle;
    ImageButton questyes, questno;
    ImageButton backbtn;
    int questox, i = 0;
    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "quest_id";
    private static final String TAG_TITLE = "quest_title";
    private static final String TAG_OX = "quest_ox";

    JSONArray quest = null;
    ArrayList<HashMap<String, String>> marrayList;
    int[] image = new int[]{R.drawable.test1, R.drawable.test2};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_question);

        questimg = (ImageView)findViewById(R.id.questimg);
        questtitle = (TextView)findViewById(R.id.questtitle);
        questyes = (ImageButton)findViewById(R.id.questyes);
        questno = (ImageButton)findViewById(R.id.questno);
        backbtn = (ImageButton)findViewById(R.id.ListBackBtn);

        questimg.setImageResource(R.drawable.test3);
        questtitle.setText("당신이 좋아하는 음식은?");


        questyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//로그인에 성공한 경우
                                String quest_id = jsonObject.getString("quest_id");
                                String quest_title = jsonObject.getString("quest_title");


                            } else {//로그인에 실패한 경우
                                Toast.makeText(getApplicationContext(), "불러오기를 실패했습니다", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                QuestionDBItem questionRequest = new QuestionDBItem(quest_id, quest_title,responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionActivity.this);
                queue.add(questionRequest);
                    }
                }

                i++;
                if (i>image.length){
                    onBackPressed();
                }
                else{
                    questimg.setImageResource(image[i]);
                    Log.e("이미지 설정 완료",getString(image[i]));
                    GetData task = new GetData();
                    task.execute(getString(image[i]));//image[i]에 대한 title db에서 가져오기
                    questox = 1;
                    //db 테이블 데이터 갱신
                }



            }
        });
        questno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i>image.length){
                    onBackPressed();
                }
                else{
                    questimg.setImageResource(image[i]);
                    Log.e("이미지 설정 완료",getString(image[i]));
                    GetData task = new GetData();
                    task.execute(getString(image[i]));//image[i]에 대한 title db에서 가져오기
                    questox = 0;
                    //db 테이블 데이터 갱신
                }
            }
        });
}
