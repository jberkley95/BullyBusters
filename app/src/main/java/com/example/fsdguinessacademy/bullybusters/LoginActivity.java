package com.example.fsdguinessacademy.bullybusters;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText emailAddress, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.loginButton);
        emailAddress = (EditText) findViewById(R.id.emailAddress);
        Password = (EditText) findViewById(R.id.Password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false);


        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = emailAddress.getText().toString();
        String password = Password.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onLoginSuccess();
                    }
                }, 3000);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailAddress.getText().toString();
        String password = Password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailAddress.setError("enter a valid email address");
            valid = false;
        } else {
            emailAddress.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            Password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            Password.setError(null);
        }

        return valid;
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        Intent intent = new Intent(LoginActivity.this, MainMenu.class);
        startActivity(intent);
        finish();
    }


    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }
}
