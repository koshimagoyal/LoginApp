package com.example.lenovo.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public Button mSendData;
    private EditText fname, lname, add, city, state, country, pin, mobno,street,bnkno,code;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef=FirebaseDatabase.getInstance().getReference("registration details");

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        country = (EditText) findViewById(R.id.country);
        pin = (EditText) findViewById(R.id.pin);
        mobno = (EditText) findViewById(R.id.mobile);
        street = (EditText) findViewById(R.id.street);
        bnkno = (EditText) findViewById(R.id.bno);
        code = (EditText) findViewById(R.id.code);
        mSendData = (Button) findViewById(R.id.btnSave);

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }

        });

    }

        private void saveData()
        {
            String name = fname.getText().toString().trim();
            String laname = lname.getText().toString().trim();

            String city1 = city.getText().toString().trim();
            String st = state.getText().toString().trim();
            String count = country.getText().toString().trim();
            String pincode = pin.getText().toString().trim();
            String mobile = mobno.getText().toString().trim();
            String streeet = street.getText().toString().trim();
            String bankno = bnkno.getText().toString().trim();
            String code1 = code.getText().toString().trim();
            if((!TextUtils.isEmpty(mobile))&&(!TextUtils.isEmpty(streeet))&&(!TextUtils.isEmpty(bankno))&&(!TextUtils.isEmpty(code1))&&(!TextUtils.isEmpty(name))&&(!TextUtils.isEmpty(laname))&&(!TextUtils.isEmpty(city1))&&(!TextUtils.isEmpty(st))&&(!TextUtils.isEmpty(count))&&(!TextUtils.isEmpty(pincode)))
            {
                if ((TextUtils.isDigitsOnly(mobile))&&(mobile.length()==10)) {

                        if (pincode.length()==6) {
                            String id = myRef.push().getKey();
                            Save save = new Save(name, laname, city1, streeet, st, count, pincode, mobile, bankno, code1);
                            myRef.child(id).setValue(save);
                            Intent my = new Intent(this,Login.class);
                            startActivity(my);
                            Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(this,"you should enter correct pincode",Toast.LENGTH_LONG).show();
                        }

                }
                else {
                    Toast.makeText(this,"you should enter correct mobile number",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this,"you should enter complete details",Toast.LENGTH_LONG).show();
            }

        }

    }



