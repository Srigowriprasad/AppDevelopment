package com.example.farmapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;
import java.util.Scanner;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.LoginButton);
        final EditText userName = findViewById(R.id.Username);
        final EditText password = findViewById(R.id.editTextTextPassword);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("ananth")&& password.getText().toString().equals("qwer")){
                switchActivity();
                }else {
                errorMessage();
                }


            }
        });
        mTextView = (TextView) findViewById(R.id.text);
    }

    private void switchActivity() {
        Intent switchActivityIntent = new Intent(this,DisplayActivity.class);
        startActivity(switchActivityIntent);
        Toast.makeText(getApplicationContext(),"Welcome !",Toast.LENGTH_SHORT).show();

    }


    private void errorMessage(){
        Toast.makeText(getApplicationContext(),"Invalid User name or Password",Toast.LENGTH_SHORT).show();
    }
}