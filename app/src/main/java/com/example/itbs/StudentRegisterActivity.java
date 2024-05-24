package com.example.itbs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentRegisterActivity extends AppCompatActivity {

    EditText signupName, signupSurname,signupEmail , signupPassword, Stu_Confirm_password;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        signupName = findViewById(R.id.Stu_Name);
        signupSurname = findViewById(R.id.Stu_Surname);
        signupEmail = findViewById(R.id.Stu_email);
        signupPassword = findViewById(R.id.Stu_password);
        signupButton = findViewById(R.id.Stu_registerbtn);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PerforAuth();

            }
        });

    }

    private void PerforAuth() {

        String name = signupName.getText().toString();
        String surname = signupSurname.getText().toString();
        String email = signupEmail.getText().toString();
        String password = signupPassword.getText().toString();
        String Confirmpassword = Stu_Confirm_password.getText().toString();

        if(!email.matches(emailPattern)){
            signupEmail.setError("Please enter a valid email address");
        } else if(password.isEmpty() || password.length() < 8){

            signupPassword.setError("Password must be at least 8 characters");
        } else if (!password.equals(Confirmpassword)){
            Stu_Confirm_password.setError("Password does not match");
        } else {
            progressDialog.setMessage("Please wait while Registering...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();

                        Toast.makeText(StudentRegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(new Intent(StudentRegisterActivity.this, StudentSIgnInActivity.class));
                        startActivity(intent);
                        finish();
                        FirebaseUser user = mAuth.getCurrentUser();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(StudentRegisterActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}