package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class checkActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button checkData;
    DatabaseReference reference;
    private TextView retrieveName, retrieveEmail, retrievePhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        editTextName=(EditText)findViewById(R.id.check);
        checkData=(Button)findViewById(R.id.data_check);
        retrieveName=(TextView)findViewById(R.id.name_search);
        retrieveEmail=(TextView)findViewById(R.id.email_search);
        retrievePhone=(TextView)findViewById(R.id.phone_search);
        reference= FirebaseDatabase.getInstance().getReference().child("Info");



        checkDataForExist();
    }

    private void checkDataForExist() {

        checkData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String checkName= editTextName.getText().toString();
              //  final String searchName=retrieveName.getText().toString();

                reference.orderByChild("Name").equalTo(checkName).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Toast.makeText(checkActivity.this, "Entered name is exist already", Toast.LENGTH_SHORT).show();
                            retrieveName.setText(checkName);


                        }
                        else{
                            Toast.makeText(checkActivity.this, "Entered name is not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
