package com.example.mbticlub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


import java.io.IOException;

import com.example.mbticlub.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupScreen extends AppCompatActivity {

    private EditText editText_ID,editText_name,edit_about,editText_mobile,editText_emailAddress,editText_password;
    Button bsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        editText_ID = findViewById(R.id.editText_ID);
        editText_emailAddress = findViewById(R.id.editText_emailAddress);
        editText_password = findViewById(R.id.editText_password);
        editText_mobile = findViewById(R.id.editText_mobile);
        editText_name = findViewById(R.id.editText_name);
        edit_about = findViewById(R.id.edit_about);


//        회원가입 버튼 클릭시 수행
        bsignup = findViewById(R.id.bsignup);
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 현재 입력되어있는 값을 가져온다
                String userID = editText_ID.getText().toString();
                String userPassword = editText_password.getText().toString();
                String userName = editText_name.getText().toString();
                String userMBTI = edit_about.getText().toString();
                String userMobile = editText_mobile.getText().toString();
                String userEmail = editText_emailAddress.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//회원 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "띠용", Toast.LENGTH_SHORT).show();

                                //로그인 화면으로 돌아감
                                Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
                                SignupScreen.this.startActivity(intent);
                            } else {//회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원등록을 실패했습니다", Toast.LENGTH_SHORT).show();
                                return;


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                SignupRequest signupRequest = new SignupRequest(userID, userPassword, userName, userMBTI, userMobile, userEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupScreen.this);
                queue.add(signupRequest);


            }
        });
    }

}
