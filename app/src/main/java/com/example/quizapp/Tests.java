package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tests extends AppCompatActivity {

    String pyQuestion [] = {"when was python released? ","python is based on which language? "};
    String pyAnswers[][] = {{"1991","1982","2004","2008"},{"C#","Swift","C","Assembly"},{"1991"},{"C"}};

    String cppQuestion [] = {"Which of the following is the correct identifier? ","Which of the following is the address operator? "};
    String cppAnswers[][] = {{"$var_name","VAR_123","varname@","None of the above"},{"@","#","&","%"},{"VAR_123"},{"&"}};

    String jQuestion [] = {"Which of the following is not a Java features? ","_____ is used to find and fix bugs in the Java programs. "};
    String jAnswers[][] = {{"Dynamic","Use of pointers","Object-oriented","Architecture Neutral"},{"JVM","JRE","JDB","JDK"},{"Use of pointers"},{"JDB"}};

    String csQuestion [] = {"Which of the following variable types can be assigned a value directly in C#? ","Which of the following converts a type to a string in C#? "};
    String csAnswers[][] = {{"Pointer types","Reference types","Value types","All of the above"},{"ToSingle","ToString","ToSbyte","ToInt64"},{"Value types"},{"ToString"}};

    TextView q;
    TextView finalScore;
    RadioGroup rg;
    RadioButton radBtn1;
    RadioButton radBtn2;
    RadioButton radBtn3;
    RadioButton radBtn4;
    RadioButton answerBtn;
    Button btn;

    int i = 0;
    int score = 0;

    public void putQandAns(int ind,String[] ques,String[][] ans){
        q.setText(ques[ind]);
        radBtn1.setText(ans[ind][0]);
        radBtn2.setText(ans[ind][1]);
        radBtn3.setText(ans[ind][2]);
        radBtn4.setText(ans[ind][3]);
    }
    public void checkAns(int ind,String [][]answers){
        int ansId = rg.getCheckedRadioButtonId();
        answerBtn = (RadioButton) findViewById(ansId);
        String ans = answerBtn.getText().toString();
        if(ans.equals(answers[ind+2][0])){
            score = score + 1;
        }
    }
    public void printScore(){
        finalScore.setBackgroundColor(Color.BLACK);
        finalScore.setTextColor(Color.WHITE);
        finalScore.setText("Game Finished " + Integer.toString(score) + " Score");
    }

    public void putQuestions(String [] questions,String [][] answers){
        putQandAns(i,questions,answers);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == (questions.length - 1)){
                    checkAns(i,answers);
                    btn.setEnabled(false);
                    printScore();
                }
                else {
                    checkAns(i,answers);
                    i = i + 1;
                    putQandAns(i,questions,answers);
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        q = (TextView) findViewById(R.id.question);
        finalScore = (TextView) findViewById(R.id.finalScore);
        rg = (RadioGroup) findViewById(R.id.rg);
        radBtn1 = (RadioButton) findViewById(R.id.rbtn1);
        radBtn2 = (RadioButton) findViewById(R.id.rbtn2);
        radBtn3 = (RadioButton) findViewById(R.id.rbtn3);
        radBtn4 = (RadioButton) findViewById(R.id.rbtn4);
        btn = (Button) findViewById(R.id.nextBtn);

        if(MainActivity.text.equals("Python")){
            putQuestions(pyQuestion,pyAnswers);
        }
        if(MainActivity.text.equals("C#")){
            putQuestions(csQuestion,csAnswers);
        }
        if(MainActivity.text.equals("C++")){
            putQuestions(cppQuestion,cppAnswers);
        }
        if(MainActivity.text.equals("Java")){
            putQuestions(jQuestion,jAnswers);
        }
    }
}
