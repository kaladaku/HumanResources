package com.resources.human.humanresources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void attm(View v) {

        Intent i1 = new Intent(MainActivity.this, EmployeeActivity.class);
        startActivity(i1);
    }

    public void notice(View v) {
        Intent i2 = new Intent(MainActivity.this, NoticeBoardActivity.class);
        startActivity(i2);
    }

}