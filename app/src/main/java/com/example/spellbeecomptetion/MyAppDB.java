package com.example.spellbeecomptetion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Author  : Indra
 **/

public class MyAppDB extends SQLiteOpenHelper {
    public MyAppDB(Context context) {
        super(context, "mydb.db", null, 1);
    }

    public List<Student> getBySql(String sql) {
        List<Student> all = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(sql, null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            int id = res.getInt(0);
            String name = res.getString(1);
            String rollNo = res.getString(2);
            int attn = res.getInt(3);
            String classIn = res.getString(4);
            Student s = new Student(id, name, rollNo, attn, classIn);
            all.add(s);
            res.moveToNext();
        }

        res.close();
        return all;
    }

    public List<Student> getAllStudent() {
        return getBySql("SELECT * from students");
    }

    public List<Student> get80Student() {
        return getBySql("SELECT * from students where eng_per > 80");
    }

    public List<Student> get30Perc() {
        return getBySql("SELECT * from students where eng_per < 30");
    }

    public List<Student> getClass(String classIn) {
        return getBySql("SELECT * from students where class_in = '" + classIn + "'");
    }


    public void addStudent(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s.name);
        contentValues.put("roll_no", s.rollNumber);
        contentValues.put("eng_per", s.engMarkPerc);
        contentValues.put("class_in", s.classIn);
        db.insert("students", null, contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table students (" +
                        "id integer primary key, " +
                        "name text, " +
                        "roll_no text, " +
                        "eng_per integer, " +
                        "class_in text " +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }
}
