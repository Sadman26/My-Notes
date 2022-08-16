package com.example.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText signupemail,signuppassword;
    private Button signupbtn;
    private TextView link;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //-----Removed Action bar and Statusbar Transparent--------
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getSupportActionBar().hide();
        //-----------------------------------------------------------
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        signupemail=findViewById(R.id.signupemail);
        signuppassword=findViewById(R.id.signuppassword);
        signupbtn=findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=signupemail.getText().toString().trim();
                String password=signupemail.getText().toString().trim();
                if(email.isEmpty())
                {
                    signupemail.setError("Enter a Valid Email Address");
                    signupemail.requestFocus();
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    signupemail.setError("Enter a Valid Email Address");
                    signupemail.requestFocus();
                }
                if(password.isEmpty())
                {
                    signuppassword.setError("Enter a Password");
                    signuppassword.requestFocus();
                }
                if(password.length()<6)
                {
                    signuppassword.setError("Minimum length of password is 6");
                    signuppassword.requestFocus();
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Registration Successfull!",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),"Registration Failed!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        link=findViewById(R.id.linktologin);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}