package com.example.readandwritedata_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReteriveBasicData extends AppCompatActivity {

    private  TextView name_View;
    private DatabaseReference mydatabase2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reterive_basic_data);

        name_View =(TextView)findViewById(R.id.nameView);
        mydatabase2= FirebaseDatabase.getInstance().getReference();

        mydatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                name_View.setText("name is  : "+ name);   // name is : {Name=ahmed}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
