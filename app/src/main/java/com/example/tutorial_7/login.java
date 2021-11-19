package com.example.tutorial_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email1, password1;
    Button btnlogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        email1 = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.pwd);
        btnlogin= (Button) findViewById(R.id.login);
        db = new DatabaseHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email1.getText().toString();
                String pass = password1.getText().toString();


                if(em.equals("") || pass.equals(""))
                {
                    Toast.makeText(login.this, "please enter valid email", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkuserpass = db.chekusernamepass(em , pass);
                    if (checkuserpass==true)
                    {
                        Toast.makeText(login.this, "login succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),welcome.class);
                        intent.putExtra("email",em);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(login.this, "login not  succesfully", Toast.LENGTH_SHORT).show();

                    }

                }





            }
        });
    }
}