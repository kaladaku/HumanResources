package com.resources.human.humanresources;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by lenovo on 30/3/17.
 */

public class CalendarActivity extends Activity {
    CalendarView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_activity);
        cal = (CalendarView) findViewById(R.id.calendarView);


        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                //    Toast.makeText(CalendarActivity.this,"Date"+ dayOfMonth +
                //          "/" + month + "/" + year ,Toast.LENGTH_LONG).show();

                month++;
                String date = dayOfMonth + "/" + month + "/" + year;

                Toast.makeText(CalendarActivity.this, "Attendance Marked For Date:" + date, Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.putExtra("DATE", date);
                setResult(1, intent);
                finish();

            }
        });
    }
}