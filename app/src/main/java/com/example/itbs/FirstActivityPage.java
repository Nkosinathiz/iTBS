package com.example.itbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivityPage extends AppCompatActivity {

    Button student;
    Button tutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        // Declaring the buttons
        tutor = (Button) findViewById(R.id.tutorbtn);

        student = (Button) findViewById(R.id.studentbtn);

        // This have to work on the logIn screen for Tutors
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivityPage.this, TutorSigninActivity2.class));

            }
        });


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivityPage.this, StudentRegisterActivity.class));
            }
        });

    }
}