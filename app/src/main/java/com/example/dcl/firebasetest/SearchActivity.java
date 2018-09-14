package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SearchActivity extends AppCompatActivity {

    EditText name;
    Button search;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        name = (EditText) findViewById(R.id.search);
        search = (Button) findViewById(R.id.search_button);

        mRef = FirebaseDatabase.getInstance().getReference().child("Info");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
            //



        });
    }
}




