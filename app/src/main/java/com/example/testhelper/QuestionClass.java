package com.example.testhelper;

import android.database.Cursor;

import java.util.ArrayList;

public class QuestionClass {
    private String question;
    private ArrayList <String> answers;
    private int rightAnswer;
    private int category;

    public QuestionClass(Cursor cursor, int number)
    {
        answers= new ArrayList<String>();
       if (cursor.getCount()>number)
            cursor.moveToPosition(number);
        else
            cursor.moveToFirst();
        question= cursor.getString(1);

        answers.add(cursor.getString(2));
        answers.add(cursor.getString(3));
        answers.add(cursor.getString(4));
        answers.add(cursor.getString(5));
        rightAnswer= cursor.getInt(6);
        category=cursor.getInt(7);
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }
}
