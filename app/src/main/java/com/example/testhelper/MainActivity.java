package com.example.testhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TheoryClick(View v)
    {
       Intent intent = new Intent(this,Theory.class);
       startActivity(intent);
    }

    public void PracticClick(View v)
    {
        Intent intent = new Intent(this,practic.class);
        startActivity(intent);
    }
}