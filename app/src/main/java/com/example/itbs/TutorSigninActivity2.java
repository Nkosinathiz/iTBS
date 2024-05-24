package com.example.itbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TutorSigninActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_signin2);

        //
        TextView btn = (TextView) findViewById(R.id.txtSignup);
        Button login = (Button) findViewById(R.id.login);


        //
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TutorSigninActivity2.this,DashboardTutor.class));
            }
        });

        //
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TutorSigninActivity2.this,TutorRegActivity.class));
            }
        });



    }
}