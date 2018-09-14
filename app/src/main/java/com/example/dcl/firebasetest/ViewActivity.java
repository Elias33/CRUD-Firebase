package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ListView mUserList;
    DatabaseReference mDatabase;
     ArrayList<String>mUserName= new ArrayList<>();
    ArrayAdapter<String>adapter;
    String name, email,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Info");
        mUserList=(ListView)findViewById(R.id.list_view);



        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    name= dataSnapshot.child("Name").getValue(String.class);
                    email= dataSnapshot.child("Email").getValue(String.class);
                    phone= dataSnapshot.child("phone").getValue(String.class);

                    mUserName.add("Name: "+name);
                    mUserName.add("Email: "+email);
                    mUserName.add("phone: "+phone);
                    adapter=new ArrayAdapter<String>(ViewActivity.this,android.R.layout.simple_list_item_1,mUserName);

                    mUserList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    mUserList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if(position==0){
                                Toast.makeText(ViewActivity.this, "Position 0", Toast.LENGTH_SHORT).show();
                            }
                            else if(position==1){
                                Toast.makeText(ViewActivity.this, "Position1", Toast.LENGTH_SHORT).show();
                                //removeValueFromFirebase();
                               // mDatabase.child("LMMaRfHg-iqkP3H5KGu").setValue("xxx");
                            }
                            else if(position==2){
                                Toast.makeText(ViewActivity.this, "pOSITION 2", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });





            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }




}
