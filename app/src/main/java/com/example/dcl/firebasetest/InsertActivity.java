package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class InsertActivity extends AppCompatActivity {


    DatabaseReference mDatabase;
    DatabaseReference mUserName;


    private EditText name, email,phone;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mDatabase=FirebaseDatabase.getInstance().getReference().child("Info");
      //  mUserName= (DatabaseReference) mDatabase.child("Info").child("Name");

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        save=(Button)findViewById(R.id.save);
        insertInformation();
    }

    private void insertInformation() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String userName= name.getText().toString();
                final String userEmail= email.getText().toString();
                final String userPhone= phone.getText().toString();


                mDatabase.orderByChild("Name").equalTo(userName).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Toast.makeText(InsertActivity.this, "Entered information already exist", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //Toast.makeText(InsertActivity.this, "Entered information is not exist", Toast.LENGTH_SHORT).show();
                            HashMap<String,String>datamap= new HashMap<String, String>();


                            datamap.put("Name",userName);
                            datamap.put("Email",userEmail);
                            datamap.put("phone",userPhone);
                            mDatabase.push().setValue(datamap);
                            Toast.makeText(InsertActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                /*

                HashMap<String,String>datamap= new HashMap<String, String>();


                datamap.put("Name",userName);
                datamap.put("Email",userEmail);
                datamap.put("phone",userPhone);
                mDatabase.push().setValue(datamap);
                Toast.makeText(InsertActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
*/





            }
        });
    }
}
