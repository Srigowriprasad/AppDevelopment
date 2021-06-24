package com.example.farmapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.ContentValues.TAG;

public class DisplayActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        TextView displayTextField = findViewById(R.id.displayText);
        requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE},1);
        mTextView = (TextView) findViewById(R.id.text);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1: if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Context context = getApplicationContext();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    loadFile(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Toast.makeText(getApplicationContext(),"in else",Toast.LENGTH_SHORT);
            }
        }
    }

    private void loadFile(String path1) throws IOException {
        TextView displayTextField = findViewById(R.id.displayText);
        String path = "/sdcard/Download/Farm.txt";
        File file = new File(path);
        if (file.exists()){
            Toast.makeText(getApplicationContext(),"In display",Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),"In display1",Toast.LENGTH_SHORT).show();
        FileReader fileReader=null;
        try {

            fileReader = new FileReader(file);
        }catch (FileNotFoundException e){

        }
        Toast.makeText(getApplicationContext(),"In display2",Toast.LENGTH_SHORT).show();
        BufferedReader br = new BufferedReader(fileReader);
        Toast.makeText(getApplicationContext(),"In display3",Toast.LENGTH_SHORT).show();

        final String s = br.readLine();
        while (s != null){
            displayTextField.append(s);
        }
    }

}