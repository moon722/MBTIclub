package com.example.mbticlub;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
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
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("포스트도착", "포스트");
        setContentView(R.layout.post);
        intent = getIntent();
        Log.e("포스트 도착", getString(intent.getIntExtra("imgint", 1)));



        backbtn = (ImageButton) findViewById(R.id.ListBackBtn);
        imgview = (ImageView) findViewById(R.id.img);
        title = (TextView) findViewById(R.id.Posttitle);
        content = (TextView) findViewById(R.id.Postcontent);
        btn_share = (ImageButton) findViewById(R.id.btn_share);
        btn_bookmark = (ImageButton) findViewById(R.id.btn_bookmark);

        imgview.setImageResource(intent.getIntExtra("imgint", 1));

        title.setText("asdf");//이미지 리소스에 대한 title, content 데이터 db에서 받아오기
        content.setText("asdf");


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


//                Bitmap image =BitmapFactory.decodeResource(getResources(),intent.getIntExtra("img",1 ));
//                String imgBitmapPath= MediaStore.Images.Media.insertImage(getContentResolver(),image,"title",null);
//                Uri bmpUri=Uri.parse(imgBitmapPath);
//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//
//                shareIntent.putExtra(Intent.EXTRA_TEXT, "asdfasdfasdf"  );
//                shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
//                shareIntent.setType("image/*");
//                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                startActivity(Intent.createChooser(shareIntent, "Share Opportunity"));


//                Intent share = new Intent(Intent.ACTION_SEND);
//                share.setType("image/*");
//
//                /**This is the image to share**/
//                Bitmap image =BitmapFactory.decodeResource(getResources(),intent.getIntExtra("img",1 ));
//
//                ContentValues values = new ContentValues();
//                values.put(MediaStore.Images.Media.TITLE, "title");
//                values.put(MediaStore.Images.Media.MIME_TYPE, "image/*");
//                Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                        values);
//                OutputStream outstream;
//                try {
//                    outstream = getContentResolver().openOutputStream(uri);
//                    image.compress(Bitmap.CompressFormat.JPEG, 100, outstream);
//                    outstream.close();
//                } catch (Exception e) {
//                    System.err.println(e.toString());
//                }
//
//                share.putExtra(Intent.EXTRA_STREAM, uri);
//                share.putExtra(Intent.EXTRA_TEXT, "YOUR_BODY_TEXT_HERE");
//                startActivity(Intent.createChooser(share, "Share Image"));


//                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
//                Sharing_intent.setType("text/plain");
//                String Test_Message = "MBTIY 정보";
//                //Uri uri = Uri.parse("android.resource://com.example.mbticlub/"+getString(intent.getIntExtra("img",1 )));
//                //Log.e("URIIII", uri.toString());
//                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);
//                //Sharing_intent.putExtra(Intent.EXTRA_STREAM, uri);
//
//                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
//                startActivity(Sharing);


//                Bitmap image = BitmapFactory.decodeResource(getResources(), intent.getIntExtra("img", 1));
//                String imgBitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), image, "title", null);
//                Uri imgBitmapUri = Uri.parse(imgBitmapPath);
//                String shareText = "Share image and text";
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("*/*");
//                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, imgBitmapUri);
//
//                Intent Sharing = Intent.createChooser(shareIntent, "공유하기");
//                startActivity(Sharing);//이미지 전달 제대로 되는것

            }
        });



    }public void HttpPostData(){
        try{
            URL url = new URL("http://mbtiy.dothome.co.kr/quest2.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDefaultUseCaches(false);
            http.setDoInput(true);                         // 서버에서 읽기 모드 지정
            http.setDoOutput(true);                       // 서버로 쓰기 모드 지정
            http.setRequestMethod("POST");
            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

            StringBuffer buffer = new StringBuffer();
            buffer.append("recom_id").append("=").append(getString(intent.getIntExtra("imgint", 1)));
            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "EUC-KR");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();

            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "EUC-KR");
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {       // 서버에서 라인단위로 보내줄 것이므로 라인단위로 읽는다
                builder.append(str + "\n");                     // View에 표시하기 위해 라인 구분자 추가
            }
            myResult = builder.toString();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void kakaolink() {
        String uri = Uri.parse("android.resource://"+ R.class.getPackage().getName()+"/" + getString(intent.getIntExtra("imgint", 1))).toString();
        Log.e("슝우우우우바라아알", uri);
        Log.e("슝우우우우바라아알", title.toString());
        FeedTemplate params = FeedTemplate
                .newBuilder(ContentObject.newBuilder("MBTIY 오늘의 추천!",
                        "http://mud-kage.kakao.co.kr/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg",
                        LinkObject.newBuilder().setWebUrl("https://developers.kakao.com")
                                .setMobileWebUrl("https://developers.kakao.com").build())
                        .setDescrption(title.getText().toString())
                        .build())
                .setSocial(SocialObject.newBuilder().setLikeCount(10).setCommentCount(20)
                        .setSharedCount(30).setViewCount(40).build())
                .addButton(new ButtonObject("웹에서 보기", LinkObject.newBuilder().setWebUrl("'https://developers.kakao.com").setMobileWebUrl("'https://developers.kakao.com").build()))
                .addButton(new ButtonObject("앱에서 보기", LinkObject.newBuilder()
                        .setWebUrl("'https://developers.kakao.com")
                        .setMobileWebUrl("'https://developers.kakao.com")
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



