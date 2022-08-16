package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText signupemail,signuppassword;
    private Button signupbtn;
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

            }
        });


    }
}