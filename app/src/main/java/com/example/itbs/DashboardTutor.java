package com.example.itbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardTutor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tutor);


        Button renlesson = (Button) findViewById(R.id.lessonbtn);

        renlesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button invoicemon = (Button) findViewById(R.id.invoicebtn);

        invoicemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardTutor.this, FirstActivityPage.class));

            }
        });

        Button note = (Button) findViewById(R.id.notesbtn);

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardTutor.this, FirstActivityPage.class));

            }
        });

        Button notification = (Button) findViewById(R.id.notificationbtn);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button setti = (Button) findViewById(R.id.settindbtn);

        setti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardTutor.this, FirstActivityPage.class));

            }
        });


        Button logout_tut = (Button) findViewById(R.id.logout_tutor);



        logout_tut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardTutor.this, FirstActivityPage.class));
            }
        });
    }
}