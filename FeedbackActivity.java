package com.example.vaibh.smartparking;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FeedbackActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileTxt;
    private Button button;


    public void feedback(View view) {

            Toast.makeText(this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();

        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        auth = FirebaseAuth.getInstance();
        profileTxt = (TextView) findViewById(R.id.textView4);
        user = auth.getCurrentUser();
        profileTxt.setText(user.getEmail());
    }
    public void onBackPressed() {

            super.onBackPressed();
        }
    }



