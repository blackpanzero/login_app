package com.example.loginapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        mPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (mPassword.getRight() - mPassword.getCompoundDrawables()[RIGHT].getBounds().width())) {
                        int selection = mPassword.getSelectionEnd();
                        if (isPasswordVisible) {
                            // set drawable image
                            mPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_off_black_24dp, 0);
                            // hide Password
                            mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            isPasswordVisible = false;
                        } else  {
                            // set drawable image
                            mPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_visibility_black_24dp, 0);
                            // show Password
                            mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            isPasswordVisible = true;
                        }
                        mPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }

    public void SetValidation() {




        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;

        }
        // Check for a valid password.
        else if (mPassword.getText().toString().isEmpty()) {
            mPassword.setError(getResources().getString(R.string.password_error));

        } else if (mPassword.getText().length() < 6) {
            mPassword.setError(getResources().getString(R.string.error_invalid_password));

        }
        else if(email.getText().toString().equals("admin@example.com") && mPassword.getText().toString().equals("password")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
        }

        else  {
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            text.setVisibility(View.VISIBLE);
            text.setBackgroundColor(Color.RED);
            counter--;
            text.setText("Attempts Left: " + Integer.toString(counter));

            if (counter == 0) {
                login.setBackgroundColor(Color.GRAY);
                login.setEnabled(false);
            }

        }




    }
}