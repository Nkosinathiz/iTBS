package com.example.itbs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class StudentSIgnInActivity extends AppCompatActivity {

    EditText loginUser, loginPassword;
    Button loginButton;
    TextView SignUpRedirectText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);


        loginUser = findViewById(R.id.StudentNumberLogin);
        loginPassword =findViewById(R.id.Student_PasswordLogin);
        SignUpRedirectText = findViewById(R.id.student_regnowSignin);
        loginButton = findViewById(R.id.Student_loginbtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()){

                } else{
                    checkUser();
                }
            }
        });

        SignUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentSIgnInActivity.this, StudentRegisterActivity.class);
                startActivity(intent);

            }
        });


    }

    public  Boolean validateUsername(){
        String val = loginUser.getText().toString();

        if (val.isEmpty()){
            loginUser.setError("Username cannot be empty");
            return false;
        } else {
            loginUser.setError(null);
            return true;
        }
    }

    public  Boolean validatePassword(){
        String val = loginPassword.getText().toString();

        if (val.isEmpty()){
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }


    }

    public void checkUser(){
        String userUsername = loginUser.getText().toString().trim();
        String userPassword = loginUser.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUser.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDB, userPassword)){
                        loginUser.setError(null);
                        Intent intent = new Intent(StudentSIgnInActivity.this, Dashboard.class);
                    } else{
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();

                    }
                } else{
                    loginUser.setError("User not found");
                    loginPassword.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    };
}