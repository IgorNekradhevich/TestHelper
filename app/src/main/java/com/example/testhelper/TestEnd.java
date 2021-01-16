package com.example.testhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestEnd extends AppCompatActivity {

    int index=0;
    int max_count;
    TextView quest, myAns,rightAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_end);
        max_count= practic.myAnswers.size();
        quest=findViewById(R.id.questTV);
        myAns= findViewById(R.id.myAnsTV);
        rightAns= findViewById(R.id.rightAnsTV);
        show(0);
    }

    public void NextClick(View v)
    {
        if (index<max_count-1)
        {
            index++;
            show(index);
        }
    }
    public  void HomeButton(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    void show(int index)
    {
        quest.setText(practic.questionList.get(index).getQuestion());
        myAns.setText("Вы ответили:\n\r"+
                practic.questionList.get(index).getAnswers().get(practic.myAnswers.get(index)-1));
        rightAns.setText("Верный ответ:\n\r"+
                practic.questionList.get(index).getAnswers()
                        .get(practic.questionList.get(index).getRightAnswer()-1));
    }

}