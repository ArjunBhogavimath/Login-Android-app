package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.editTextTextPersonName);
        Password = (EditText) findViewById(R.id.editTextTextPassword);
        Info = (TextView) findViewById(R.id.textViewinfo);
        Login = (Button) findViewById(R.id.button3);

        Info.setText("No of Attempts Remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("mallikarjunaiah")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);


            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            counter--;

            Info.setText("No of Attempts Remaining:" + counter);
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

            if (counter == 0) {
                Login.setEnabled(false);
            }

        }
    }

}