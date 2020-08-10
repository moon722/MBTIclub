package com.example.mbticlub;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.message.template.ButtonObject;
import com.kakao.message.template.ContentObject;
import com.kakao.message.template.FeedTemplate;
import com.kakao.message.template.LinkObject;
import com.kakao.message.template.SocialObject;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.util.helper.log.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    Intent intent;
    ImageView imgview;
    TextView title, content;
    ImageButton backbtn, btn_share, btn_bookmark;
    private static final int REQUEST_EXTERNAL_STORAGE_CODE = 1;
    boolean permissionCheck = false;
    String myResult;
    int list_cnt;
    Context context;
    int bookmark = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        intent = getIntent();


        backbtn = (ImageButton) findViewById(R.id.ListBackBtn);
        imgview = (ImageView) findViewById(R.id.img);
        title = (TextView) findViewById(R.id.Posttitle);
        content = (TextView) findViewById(R.id.Postcontent);
        btn_share = (ImageButton) findViewById(R.id.btn_share);
        btn_bookmark = (ImageButton) findViewById(R.id.btn_bookmark);
        imgview.setImageResource(getApplicationContext().getResources().getIdentifier(intent.getStringExtra("imgint"),"drawable",getApplicationContext().getPackageName()));


        String url = "http://mbtiy.dothome.co.kr/recommand.php?recom_id="+intent.getStringExtra("imgint");
        selectDatabase selectDatabase = new PostActivity.selectDatabase(url, null);
        selectDatabase.execute();// AsyncTask는 .excute()로 실행된다.

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaolink();
            }
        });

        btn_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bookmark == 0){
                    btn_bookmark.setImageResource(R.drawable.ic_baseline_bookmark_24);
                    bookmark = 1;
                    Toast.makeText(getApplicationContext(), "Bookmarked", Toast.LENGTH_SHORT).show();
                }
                else{
                    btn_bookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    bookmark = 0;
                    Toast.makeText(getApplicationContext(), "Bookmark released", Toast.LENGTH_SHORT).show();
                }
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

            for (int i=0; i < jsonArray.length(); i++) {
                JSONObject output = jsonArray.getJSONObject(i);
                title.setText(output.getString("title"));
                content.setText(output.getString("content"));


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void kakaolink() {
        FeedTemplate params = FeedTemplate
                .newBuilder(ContentObject.newBuilder("Daily Suggestion for your MBTI type!",
                        "https://postfiles.pstatic.net/MjAyMDA4MDhfMTgw/MDAxNTk2ODYyNTU4NDg3.LxlLrxotw8pRqOPWS_0YN36r57sKvK7TyPEbWG8SHjsg.OKHamTs1dpJ_CV8CM0F0cRpxcGJDpabIXJq-Wy_PPKAg.PNG.heryms/logo.png?type=w773",
                        LinkObject.newBuilder().setWebUrl("market://details?id=com.example.mbticlub")
                                .setMobileWebUrl("market://details?id=com.example.mbticlub").build())
                        .setDescrption("You can set it up and check it!")
                        .build())
                .setSocial(SocialObject.newBuilder().setLikeCount(10)
                        .setSharedCount(30).setViewCount(40).build())
                .addButton(new ButtonObject("View on the Web", LinkObject.newBuilder().setWebUrl("'market://details?id=com.example.mbticlub").setMobileWebUrl("'market://details?id=com.example.mbticlub").build()))
                .addButton(new ButtonObject("View on the App", LinkObject.newBuilder()
                        .setWebUrl("'market://details?id=com.example.mbticlub")
                        .setMobileWebUrl("'market://details?id=com.example.mbticlub")
                        .setAndroidExecutionParams("key1=value1")
                        .setIosExecutionParams("key1=value1")
                        .build()))
                .build();

        Map<String, String> serverCallbackArgs = new HashMap<String, String>();
        serverCallbackArgs.put("user_id", "${current_user_id}");
        serverCallbackArgs.put("product_id", "${shared_product_id}");

        KakaoLinkService.getInstance().sendDefault(this, params, serverCallbackArgs, new ResponseCallback<KakaoLinkResponse>() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                Logger.e(errorResult.toString());
            }

            @Override
            public void onSuccess(KakaoLinkResponse result) {
                // 템플릿 밸리데이션과 쿼터 체크가 성공적으로 끝남. 톡에서 정상적으로 보내졌는지 보장은 할 수 없다. 전송 성공 유무는 서버콜백 기능을 이용하여야 한다.
            }
        });
    }

}



