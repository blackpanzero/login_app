package com.example.loginapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText email, mPassword;
    Button login;
    TextView text;
    boolean isEmailValid, isPasswordValid, isPasswordVisible;
    int counter = 3;
    int counter_2=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        text=(TextView) findViewById(R.id.text_view);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });


    }


    
}