package com.resources.human.humanresources;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 29/3/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE = "empapp.db";
    static final int VERSION = 1;
    static final String TABLE = "emp";
    static final String TABLE_DEPT = "dept";

    static final String C_ID = "_id";
    static final String C_ENAME = "ename";
    static final String C_WORKING_HOURS = "hours";
    static final String C_SALARY = "salary";
    static final String C_Date = "date_of_atten";

    // Override constructor
    public DBHelper(Context context) {
        super(context, DATABASE, null, VERSION);

    }

    // Override onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create Employee table with following fields
        // _ID, ENAME, DESIGNATION and SALARY
        db.execSQL("CREATE TABLE " + TABLE + " ( " + C_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_ENAME + " text, "
                + C_WORKING_HOURS + " text, " + C_SALARY + " text, " + C_Date + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop old version table
        db.execSQL("Drop table " + TABLE);

        // Create New Version table
        onCreate(db);
    }
}