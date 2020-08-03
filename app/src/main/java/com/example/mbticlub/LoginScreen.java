package com.example.mbticlub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginScreen extends AppCompatActivity {
    private EditText editText_ID,editText_password;
    Button blogin,bsignup;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //find id of view
        editText_ID=findViewById(R.id.editText_emailAddress);
        editText_password=findViewById(R.id.editText_password);

        bsignup=findViewById(R.id.bsignup);
        blogin=findViewById(R.id.blogin);


        blogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View view) {
                //get input text from edittext and store in string
                String userID = editText_ID.getText().toString();
                String userPassword = editText_password.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//로그인에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                String userPassword = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인을 성공했습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                                intent.putExtra("userId", userID);
                                intent.putExtra("userPassword", userPassword);

                                startActivity(intent);
                            } else {//로그인에 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인을 실패했습니다", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginScreen.this);
                queue.add(loginRequest);

            }
        });
        //회원가입 버튼 클릭시 수행
        bsignup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View view) {
                // call method for user login
                Intent intent = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(intent);

            }
        });


    }


}
