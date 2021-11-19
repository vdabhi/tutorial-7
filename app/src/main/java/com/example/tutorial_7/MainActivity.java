package com.example.tutorial_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editfname,editlname,editemail,editpassword;
    Button btnadddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        myDb = new DatabaseHelper( this );

        editfname =(EditText)findViewById( R.id.fname );
        editlname =(EditText)findViewById( R.id.lname );
        editemail=(EditText)findViewById( R.id.email );
        editpassword=(EditText)findViewById( R.id.pwd );
        btnadddata=(Button)findViewById( R.id.insert );
        addData();

    }

    private void addData() {
        btnadddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertData( editfname.getText().toString(),
                        editlname.getText().toString(),
                        editemail.getText().toString(),
                        editpassword.getText().toString());
                if(isInserted=true) {
                    Toast.makeText( MainActivity.this,"data inserted",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( MainActivity.this, login.class );
                    startActivity(intent);
                }
                else
                    Toast.makeText( MainActivity.this,"data not inserted",Toast.LENGTH_SHORT).show();

            }
        });

    }
}