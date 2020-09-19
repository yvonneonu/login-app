package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;

    private final String Username = "Admin";
    private final String Password = "12345678";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText eName = findViewById(R.id.etName);
        final EditText ePassword = findViewById(R.id.etPassword);
        final TextView eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        final Button eLogin = findViewById(R.id.btnLogin);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();
                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText( MainActivity.this, "Please enter all details correctly!", Toast.LENGTH_SHORT).show();
                }else {
                    isValid = validate(inputName, inputPassword);

                    if (!isValid){
                        counter--;
                        Toast.makeText( MainActivity.this, "Incorrect credentials entered", Toast.LENGTH_SHORT).show();
                        eAttemptsInfo.setText("No of attempts remaining: " + counter);
                        if (counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }else {
                        Toast.makeText( MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                        // Add the code to go to new activity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
    private boolean validate(String name, String password) {
        if(name.equals(Username) && password.equals(Password)) {
            return true;
    }
        return false;
    }
}