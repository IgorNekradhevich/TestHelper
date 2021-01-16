package com.example.testhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Theory extends AppCompatActivity {

    ArrayList<String> Categories= new ArrayList<String>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        recyclerView= findViewById(R.id.CategoryList);

     /*   DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper .create_db();
        SQLiteDatabase sqlite = databaseHelper .open();
        Cursor cursor=sqlite.rawQuery("SELECT * FROM Category",null);

        cursor.moveToFirst();
        while (!cursor.isLast()) {
            Categories.add( cursor.getString(1));
            cursor.moveToNext();
        }*/
        Categories.add("!!!!!");
        Categories.add("!!!!!");
        Categories.add("!!!!!");
CategoryAdapter categiryAdapter = new CategoryAdapter(this,Categories);
Toast.makeText(this,  String.valueOf(categiryAdapter.getItemCount()), Toast.LENGTH_LONG).show();
           recyclerView.setAdapter(categiryAdapter);

    }
}