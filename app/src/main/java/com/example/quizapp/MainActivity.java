package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button mainBtn;
    Button registerBtn;
    EditText username;
    EditText password;
    Spinner spinner;
    static String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String names [] = {"Uzair","Farhan","Atif",""};
        String passwords [] = {"1234","4567","4321",""};

        mainBtn = (Button) findViewById(R.id.mainBtn);
        username = (EditText) findViewById(R.id.usernamBox);
        password = (EditText) findViewById(R.id.passwordBox);
        registerBtn = (Button) findViewById(R.id.regBtn);
        spinner = (Spinner) findViewById(R.id.spin);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.subjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names[3] = username.getText().toString();
                passwords[3] = password.getText().toString();

                Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_LONG).show();
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Boolean flag = true;
                String checkName = username.getText().toString();
                for (int i = 0;i<names.length;i++){

                    if (checkName.equals(names[i])){
                        System.out.println(i);
                        if (password.getText().toString().equals(passwords[i])){
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    Toast.makeText(getApplicationContext(), "Incorrect password or username", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent myIntent = new Intent(MainActivity.this, Tests.class);
                    MainActivity.this.startActivity(myIntent);
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}