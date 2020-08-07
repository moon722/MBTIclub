package com.example.mbticlub;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class QuestionActivity extends AppCompatActivity {
    ImageView questimg;
    TextView questtitle, questcontent;
    ImageButton questyes, questno, questnorm;
    ImageButton backbtn;


    private static String TAG = "QuestionActivity";

    private static final String TAG_JSON="webnautes";
    private static final String TAG_ID = "quest_id";
    private static final String TAG_TITLE = "quest_title";
    private static final String TAG_OX ="quest_ox";
    int i = 0;

    int list_cnt;
    String [] getid;
    String [] gettitle;
    String [] getcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_question);


        questimg = (ImageView) findViewById(R.id.questimg);
        questtitle = (TextView) findViewById(R.id.questtitle);
        questcontent = (TextView) findViewById(R.id.questcontent);
        questyes = (ImageButton) findViewById(R.id.questyes);
        questnorm = (ImageButton) findViewById(R.id.questnorm);
        questno = (ImageButton) findViewById(R.id.questno);
        backbtn = (ImageButton) findViewById(R.id.ListBackBtn);


        String url = "http://mbtiy.dothome.co.kr/quest2.php";
        selectDatabase selectDatabase = new selectDatabase(url, null);
        selectDatabase.execute();// AsyncTask는 .excute()로 실행된다.


        questnorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i >= getid.length) {
                    onBackPressed();
                } else {
                    int resId = getResources().getIdentifier(getid[i], "drawable", getPackageName());
                    questimg.setImageResource(resId);
                    questtitle.setText(gettitle[i]);
                    questcontent.setText(getcontent[i]);
                }

            }
        });

        questyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i >= getid.length) {
                    onBackPressed();
                } else {
                    int resId = getResources().getIdentifier(getid[i], "drawable", getPackageName());
                    questimg.setImageResource(resId);
                    questtitle.setText(gettitle[i]);
                    questcontent.setText(getcontent[i]);
                }

            }
        });
        questno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i >= getid.length) {
                    onBackPressed();
                } else {
                    int resId = getResources().getIdentifier(getid[i], "drawable", getPackageName());
                    questimg.setImageResource(resId);
                    questtitle.setText(gettitle[i]);
                    questcontent.setText(getcontent[i]);
                }
            }
        });


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }class selectDatabase extends AsyncTask<Void, Void, String> {

        private String url1;
        private ContentValues values1;
        String result1; // 요청 결과를 저장할 변수.

        public selectDatabase(String url, ContentValues contentValues) {
            this.url1 = url;
            this.values1 = contentValues;
        }

        @Override
        protected String doInBackground(Void... params) {
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result1 = requestHttpURLConnection.request(url1, values1);
            Log.e("결과", result1);// 해당 URL로 부터 결과물을 얻어온다.
            return result1; // 여기서 당장 실행 X, onPostExcute에서 실행
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //txtView.setText(s); // 파서 없이 전체 출력
            doJSONParser(s); // 파서로 전체 출력
        }
    }

    // 받아온 json 데이터를 파싱합니다..
    public void doJSONParser(String string) {
        try {
            String result = "";
            JSONObject jsonObject = new JSONObject(string);
            JSONArray jsonArray = jsonObject.getJSONArray("webnautes");
            list_cnt = jsonArray.length();
            getid = new String[list_cnt];
            gettitle = new String[list_cnt];
            getcontent = new String[list_cnt];
            for (int i=0; i < jsonArray.length(); i++) {
                JSONObject output = jsonArray.getJSONObject(i);
                getid[i]  = output.getString("id");
                gettitle[i] = output.getString("title");
                getcontent[i] = output.getString("content");

                Log.e("슈우우우우바아아알", getid[i]+gettitle[i]+getcontent[i]);

            }
            int resId = getResources().getIdentifier(getid[i], "drawable", getPackageName());
            questimg.setImageResource(resId);
            questtitle.setText(gettitle[i]);
            questcontent.setText(getcontent[i]);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}