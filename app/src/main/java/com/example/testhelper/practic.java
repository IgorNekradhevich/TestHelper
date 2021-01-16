package com.example.testhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class practic extends AppCompatActivity {

    Cursor cursor;
    ArrayList<RadioButton> answers;
    TextView question;
    TextView number;
    int index=0;
    int max_count=5;
    int right_ans=0;
    public static ArrayList<QuestionClass> questionList;
    public static ArrayList<Integer> myAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practic);
        myAnswers= new ArrayList<>();
        questionList=new ArrayList<QuestionClass>();
        answers = new ArrayList<>();
        answers.add(findViewById(R.id.Var1RB));
        answers.add(findViewById(R.id.Var2RB));
        answers.add(findViewById(R.id.Var3RB));
        answers.add(findViewById(R.id.Var4RB));
        question = findViewById(R.id.questionTV);
        number= findViewById(R.id.number);

        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            databaseHelper.create_db();
            SQLiteDatabase sqlite = databaseHelper.open();
            cursor = sqlite.rawQuery("SELECT * FROM questiontable", null);

            Random rnd= new Random();
            for (int i =0; i<max_count;i++)
            {
               // int x= rnd.nextInt(cursor.getCount());
                questionList.add( new QuestionClass(cursor,i));
            }

            showQuestion(index);
        } catch (Exception e) {
            question.setText("Конструктор"+ e.getMessage());
        }
    }

    public void nextClick(View v)
    {
        try {
            if (index < max_count-1) {
                for (int i = 0; i < 4; i++) {
                    if (answers.get(i).isChecked()==true && i == questionList.get(index).getRightAnswer() - 1) {
                        right_ans++;
                        myAnswers.add(i+1);
                    }
                }
                index++;
                number.setText("Вопрос " + String.valueOf(index) + " из "
                        + String.valueOf(max_count) + " из них верных " + String.valueOf(right_ans));
                showQuestion(index);
            }
            else
            {
                Intent intent = new Intent(this,TestEnd.class);
                startActivity(intent);
            }
        }catch (Exception e)
        {
            question.setText(e.getMessage());
        }
    }
    void showQuestion(int index)
    {
        try {
            question.setText(questionList.get(index).getQuestion());
            for (int i = 0; i < 4; i++)
                answers.get(i).setText(questionList.get(index).getAnswers().get(i));
        }
        catch (Exception e)
        {
            question.setText(e.getMessage());
        }
    }
}