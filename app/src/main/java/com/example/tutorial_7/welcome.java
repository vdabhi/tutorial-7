package com.example.tutorial_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
    TextView Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        Tv = (TextView)findViewById(R.id.textView2);
        Intent i =getIntent();
        String sr = i.getStringExtra("email");
        Tv.setText(sr);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About");
        menu.add("Logout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("About"))
            Toast.makeText( this,"About Selected",Toast.LENGTH_SHORT).show();
        else if (item.getTitle().equals("Logout")) {
            Toast.makeText(this, "Logout Secessfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(welcome.this, login.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}