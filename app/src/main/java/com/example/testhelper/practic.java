package com.example.testhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class practic extends AppCompatActivity {

    Cursor cursor;
    ArrayList<RadioButton> answers;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practic);

        answers = new ArrayList<>();
        answers.add(findViewById(R.id.Var1RB));
        answers.add(findViewById(R.id.Var2RB));
        answers.add(findViewById(R.id.Var3RB));
        answers.add(findViewById(R.id.Var4RB));
        question = findViewById(R.id.questionTV);
        try {


            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            databaseHelper.create_db();
            SQLiteDatabase sqlite = databaseHelper.open();
            cursor = sqlite.rawQuery("SELECT * FROM questiontable", null);
            cursor.moveToFirst();
            question.setText(cursor.getString(1));
            answers.get(0).setText(cursor.getString(2));
            answers.get(1).setText(cursor.getString(3));
            answers.get(2).setText(cursor.getString(4));
            answers.get(3).setText(cursor.getString(5));
        } catch (Exception e) {
            question.setText(e.getMessage());
        }
    }
}