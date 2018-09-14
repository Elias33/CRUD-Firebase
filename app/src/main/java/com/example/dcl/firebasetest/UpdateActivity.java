package com.example.dcl.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {


    EditText name;
    Button supdate;
    DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mref= FirebaseDatabase.getInstance().getReference().child("Info");
        name=(EditText)findViewById(R.id.name);
        supdate=(Button)findViewById(R.id.update);
        supdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateName= name.getText().toString();
                mref.child("Name").setValue(updateName);
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
