package com.example.sharedpreferencessample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsername;
    private String username;
    private SharedPreferences preferences;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        findViews();
        setListeners();
        username=UserDataManager.getUserData(this).getUsername();
        tvUsername.setText(username);

    }

    private void findViews(){

        tvUsername=findViewById(R.id.tv_username);
        btnLogout=findViewById(R.id.btnLogout);
    }

    private void setListeners(){

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDataManager.clearUserData(HomeActivity.this);
                finish();
            }
        });

    }

}
