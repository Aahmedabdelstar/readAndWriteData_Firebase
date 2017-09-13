package com.example.readandwritedata_firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ToAddComplexData extends AppCompatActivity {

    private EditText editText_Name;
    private EditText editText_Email;
    private Button   btn_Store;

    private DatabaseReference mydatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_add_complex_data);

        editText_Name = (EditText)findViewById(R.id.editTextName);
        editText_Email = (EditText)findViewById(R.id.editTextEmail);
        btn_Store       = (Button)findViewById(R.id.btnStore);

        mydatabase = FirebaseDatabase.getInstance().getReference().child("Users");


        btn_Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText_Name.getText().toString().trim();
                String email = editText_Email.getText().toString().trim();

                HashMap<String , String > datamap = new HashMap<String, String>();
                datamap.put("Name " , name);
                datamap.put("Email " , email);

                mydatabase.push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(ToAddComplexData.this, "Stored succcessfully" , Toast.LENGTH_LONG).show();
                        }else
                        {
                            Toast.makeText(ToAddComplexData.this, "Error" , Toast.LENGTH_LONG).show();
                        }

                    }
                });



            }
        });

    }
}
