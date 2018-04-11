package com.resources.human.humanresources;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by lenovo on 29/3/17.
 */

public class EmployeeActivity extends Activity implements View.OnClickListener {

    // Primitive Variables
    String selected_ID = "";

    // Widget GUI Declare
    EditText txtEname, txtDesig, txtSalary;
    Button btnAddEmployee;
    ListView lvEmployees;

    // DB Objects
    DBHelper helper;
    SQLiteDatabase db;

    // Adapter Object
    SimpleCursorAdapter adapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_activity);

        // Init DB Objects
        helper = new DBHelper(this);

        // Widget GUI Init
        txtEname = (EditText) findViewById(R.id.txtEname);
        txtDesig = (EditText) findViewById(R.id.txtDesig);
        txtSalary = (EditText) findViewById(R.id.txtSalary);
        lvEmployees = (ListView) findViewById(R.id.lvEmployees);

        btnAddEmployee = (Button) findViewById(R.id.btnAdd);
        //  btnUpdate = (Button) findViewById(R.id.btnUpdate);
        // btnDelete = (Button) findViewById(R.id.btnDelete);

        // Attached Listener
        btnAddEmployee.setOnClickListener(this);
        // btnUpdate.setOnClickListener(this);
        //btnDelete.setOnClickListener(this);
        lvEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String name, desig, salary;

                // Display Selected Row of Listview into EditText widget

                Cursor row = (Cursor) adapter.getItem(position);
                selected_ID = row.getString(0);
                Toast.makeText(EmployeeActivity.this, "ID:" + selected_ID, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EmployeeActivity.this, CalendarActivity.class);

                startActivityForResult(intent, 1);
            }
        });

        // Fetch Data from database
        fetchData();
    }

    @Override
    public void onClick(View v) {

        // Perform CRUD Operation

        if (v == btnAddEmployee) {

            // Add Record with help of ContentValues and DBHelper class object
            ContentValues values = new ContentValues();
            values.put(DBHelper.C_ENAME, txtEname.getText().toString());
            values.put(DBHelper.C_WORKING_HOURS, txtDesig.getText().toString());
            values.put(DBHelper.C_SALARY, txtSalary.getText().toString());
            values.put(DBHelper.C_Date, "");
            // Call insert method of SQLiteDatabase Class and close after
            // performing task
            db = helper.getWritableDatabase();
            db.insert(DBHelper.TABLE, null, values);
            db.close();

            clearFields();
            Toast.makeText(this, "Employee Added Successfully",
                    Toast.LENGTH_LONG).show();

            // Fetch Data from database and display into listview
            fetchData();

        }
    }

    // Clear Fields
    private void clearFields() {
        txtEname.setText("");
        txtDesig.setText("");
        txtSalary.setText("");
    }

    // Fetch Fresh data from database and display into listview
    private void fetchData() {
        db = helper.getReadableDatabase();

        Cursor c = db.query(DBHelper.TABLE, null, null, null, null, null, null);


        adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_view,
                c,
                new String[]{DBHelper.C_ENAME, DBHelper.C_SALARY,
                        DBHelper.C_WORKING_HOURS, DBHelper.C_Date},
                new int[]{R.id.lblEname, R.id.lblSalary, R.id.lblDesignation, R.id.textatt}, 1);
        lvEmployees.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {


            String date = data.getStringExtra("DATE");

            ContentValues contentValues = new ContentValues();
            contentValues.put(DBHelper.C_Date, date);

            db.update(DBHelper.TABLE, contentValues, DBHelper.C_ID + "=?", new String[]{selected_ID});


            fetchData();


        }


    }
}