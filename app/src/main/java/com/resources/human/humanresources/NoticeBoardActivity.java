package com.resources.human.humanresources;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by lenovo on 29/3/17.
 */

public class NoticeBoardActivity extends Activity {
    private RelativeLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private TextView tv1, tv2, tv3, tv4, tv5;
    int count = 1;
    String s1;
    String tds1, tds2, tds3, tds4, tds5;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_board_activity);
        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);
        tv3 = (TextView) findViewById(R.id.text_note3);
        tv4 = (TextView) findViewById(R.id.text_note4);
        tv5 = (TextView) findViewById(R.id.text_note5);
        mButton = (Button) findViewById(R.id.button4);
        mEditText = (EditText) findViewById(R.id.editText);
        count = 1;

    }

    public void gets(View v) {
        SharedPreferences save = this.getSharedPreferences("save", MODE_WORLD_READABLE);
        SharedPreferences save2 = this.getSharedPreferences("save2", MODE_WORLD_READABLE);
        SharedPreferences save3 = this.getSharedPreferences("save3", MODE_WORLD_READABLE);
        SharedPreferences save4 = this.getSharedPreferences("save4", MODE_WORLD_READABLE);
        SharedPreferences save5 = this.getSharedPreferences("save5", MODE_WORLD_READABLE);

        String tds1 = save.getString("store1", "");
        String tds2 = save2.getString("store2", "");
        String tds3 = save2.getString("store3", "");
        String tds4 = save2.getString("store4", "");
        String tds5 = save2.getString("store5", "");


        tv1.setText(tds1);
        tv2.setText(tds2);
        tv3.setText(tds3);
        tv4.setText(tds4);
        tv5.setText(tds5);

    }

    public void create(View v) {
        if (count > 5) {
            count = 1;
        }
        if (count == 1) {
            s1 = mEditText.getText().toString();
            tv1.setText("1." + s1);
            tds1 = mEditText.getText().toString();
            tds1 = "2." + tds1;
            ++count;
            SharedPreferences save = this.getSharedPreferences("save", MODE_WORLD_READABLE);
            SharedPreferences.Editor editor = save.edit();
            editor.putString("store1", tds1);
            editor.commit();
            mEditText.setText("");
        } else if (count == 2) {
            s1 = mEditText.getText().toString();
            tv2.setText("2." + s1);
            tds2 = mEditText.getText().toString();
            tds2 = "2." + tds2;
            ++count;
            SharedPreferences save2 = this.getSharedPreferences("save2", MODE_WORLD_READABLE);
            SharedPreferences.Editor editor1 = save2.edit();
            editor1.putString("store2", tds2);
            editor1.commit();
            mEditText.setText("");

        } else if (count == 3) {
            s1 = mEditText.getText().toString();
            tv3.setText("3." + s1);
            tds3 = mEditText.getText().toString();
            tds3 = "3." + tds3;
            ++count;
            SharedPreferences save3 = this.getSharedPreferences("save3", MODE_WORLD_READABLE);
            SharedPreferences.Editor editor2 = save3.edit();
            editor2.putString("store3", tds3);
            editor2.commit();
            mEditText.setText("");
        } else if (count == 4) {
            s1 = mEditText.getText().toString();
            tv4.setText("4." + s1);
            tds4 = mEditText.getText().toString();
            tds4 = "4." + tds4;
            ++count;
            SharedPreferences save4 = this.getSharedPreferences("save4", MODE_WORLD_READABLE);
            SharedPreferences.Editor editor3 = save4.edit();
            editor3.putString("store4", tds4);
            editor3.commit();
            mEditText.setText("");
        } else if (count == 5) {
            s1 = mEditText.getText().toString();
            tv5.setText("5." + s1);
            tds5 = mEditText.getText().toString();
            tds5 = "5." + tds5;
            ++count;
            SharedPreferences save5 = this.getSharedPreferences("save5", MODE_WORLD_READABLE);
            SharedPreferences.Editor editor4 = save5.edit();
            editor4.putString("store4", tds5);
            editor4.commit();
            mEditText.setText("");
        }

    }
}