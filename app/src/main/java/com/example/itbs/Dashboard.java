package com.example.itbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    TextView textView;
    Button logout_stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textView = findViewById(R.id.user_details);


        Button selfstudy = (Button) findViewById(R.id.self_studybtn);

        selfstudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,SelfStudyMenu.class));
            }
        });

        //

        Button test = (Button) findViewById(R.id.testbtn);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, FirstActivityPage.class));
            }
        });


        Button tut = (Button) findViewById(R.id.tutoringbtn);

        tut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, FirstActivityPage.class));
            }
        });

        //

        //

        Button notifications = (Button) findViewById(R.id.notisbtn);

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, FirstActivityPage.class));
            }
        });
        //
        Button settings = (Button) findViewById(R.id.settbtn);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, FirstActivityPage.class));
            }
        });
        //
        logout_stu = (Button) findViewById(R.id.logout_student);

        logout_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                startActivity(new Intent(Dashboard.this, StudentSIgnInActivity.class));
            }
        });
    }
}