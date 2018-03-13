package com.example.lenovo.loginapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText fnam,lnam;
    private Button button;
    private ProgressDialog progressDialog;
    private FirebaseDatabase database;
    private DatabaseReference myref;
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database=FirebaseDatabase.getInstance();

        fnam = (EditText) findViewById(R.id.fname1);
        lnam = (EditText) findViewById(R.id.lname1);
        button = (Button) findViewById(R.id.btnSave);
        progressDialog = new ProgressDialog(this);
        button.setOnClickListener(this);

    }

    private void userLogin(){
        final String email=fnam.getText().toString().trim();
        String pass = lnam.getText().toString().trim();
        if(TextUtils.isEmpty(email)&&TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"enter correct details",Toast.LENGTH_LONG).show();
        }
        else
        {
            myref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value=dataSnapshot.getValue(String.class);
                    Log.d(TAG,"value is "+value);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG,"Failed to read value", databaseError.toException());
                }
            });

        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }
    public void onClick(View view)
    {
            userLogin();
    }
}
