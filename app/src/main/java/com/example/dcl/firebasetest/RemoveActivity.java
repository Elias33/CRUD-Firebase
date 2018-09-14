package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RemoveActivity extends AppCompatActivity {

    EditText name;
    Button remove;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        name=(EditText)findViewById(R.id.edit_name);
        remove=(Button)findViewById(R.id.remove_button);
        mDatabase= FirebaseDatabase.getInstance().getReference();

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String deletValue= name.getText().toString();

                Query query= mDatabase.child("Info").orderByChild("Name").equalTo(deletValue);
               query.addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                       dataSnapshot.getRef().setValue(null);
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
        });
    }
}
