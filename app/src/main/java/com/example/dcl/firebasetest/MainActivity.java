package com.example.dcl.firebasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button add,view, update, search, remove, removaAll,check;
    DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.add);
        update=(Button)findViewById(R.id.update);
        search=(Button)findViewById(R.id.search);
        remove=(Button)findViewById(R.id.remove);
        view=(Button)findViewById(R.id.view);
        removaAll=(Button)findViewById(R.id.remove_all);
        check=(Button)findViewById(R.id.check);
        mref= FirebaseDatabase.getInstance().getReference();



        insertMethod();
        updateMethod();
        searchMethod();
        removeMethod();
        viewMethod();
        removaAllMethod();
        checkMethod();





        //delete

        //update


        //search



    }

    private void checkMethod() {

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), checkActivity.class));

            }
        });
    }

    private void removaAllMethod() {

        removaAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().removeValue();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void viewMethod() {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewActivity.class));
            }
        });
    }

    private void insertMethod() {

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),InsertActivity.class));

            }
        });
    }


    private void updateMethod(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),UpdateActivity.class));

            }
        });

    }

    private void removeMethod(){

        //remove
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RemoveActivity.class));
            }
        });

    }


    private void searchMethod(){
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SearchActivity.class));
            }
        });
    }
}
