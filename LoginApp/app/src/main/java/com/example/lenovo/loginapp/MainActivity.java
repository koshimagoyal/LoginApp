package com.example.lenovo.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private EditText fname, lname, add, city, state, country, pin, mobno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fname = (EditText) findViewById(R.id.fname);
        mSendData = (Button) findViewById(R.id.btnSave);

    }

    protected void send(View view)
        {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReference("loginapp-644d9");


        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference my = myref.child("user");

                my.child("first name").setValue(fname);


            }
        });

    }
    }


