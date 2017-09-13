package com.example.readandwritedata_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private Button change;
    private DatabaseReference mydatabase;
    private EditText nameField;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change = (Button) findViewById(R.id.changeToData);
        mydatabase = FirebaseDatabase.getInstance().getReference();

        //to puch by rondom Key
        //mydatabase = FirebaseDatabase.getInstance().getReference().child("usrers");

        nameField = (EditText)findViewById(R.id.editTextName);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String name = nameField.getText().toString().trim();
               mydatabase.child("name").setValue(name);

                Intent intent = new Intent(MainActivity.this,ReteriveMultipleData.class);
                startActivity(intent);

                //to puch rondom key
                //mydatabase.push().setValue(name);

            }
        });


    }
}
