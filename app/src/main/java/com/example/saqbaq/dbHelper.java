package com.example.saqbaq;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(@Nullable Context context) {
        super(context,"StudentSabaqDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR , rollno VARCHAR, sabaq int, sabqi int, manzil int)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Student std)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO students (name, rollno, sabaq, sabqi, manzil) values ('"+std.getName()+"','"+std.getRollNo()+"',"+std.getSabaq()+","+std.getSabqi()+","+std.getManzil()+")";
        db.execSQL(query);
    }

    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> list = new ArrayList<Student>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT id, name, rollno, sabaq, sabqi, manzil from students";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                list.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            }
        }
        return list;
    }

    public Student getStudent(int id)
    {
        ArrayList<Student> list = new ArrayList<Student>();
        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("checkmyId",String.valueOf(id));

        String query = "SELECT id, name, rollno, sabaq, sabqi, manzil from students";
        Log.d("checkmyId",query);
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                list.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            }
        }

        Student std = new Student();

        for(Student stdt : list)
        {
            if(stdt.getId() == id)
            {
                std.setId(stdt.getId());
                std.setName(stdt.getName());
                std.setRollNo(stdt.getRollNo());
                std.setSabaq(stdt.getSabaq());
                std.setSabqi(stdt.getSabqi());
                std.setManzil(stdt.getManzil());
            }
        }

        return std;
    }

    public int getSabaq(int id)
    {
        int sabaq = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT sabaq from students where id = "+id+" LIMIT 1";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                sabaq = cursor.getInt(0);
            }
        }
        return sabaq;
    }

    public int getSabqi(int id)
    {
        int sabqi = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT sabqi from students where id = "+id+" LIMIT 1";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                sabqi = cursor.getInt(0);
            }
        }
        return sabqi;
    }

    //manzil
    public int getManzil(int id)
    {
        int manzil = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT manzil from students where id = "+id+" LIMIT 1";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                manzil = cursor.getInt(0);
            }
        }
        return manzil;
    }

    public void delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM students where id = "+id+"";
        db.execSQL(query);
    }

    public void updateSabaq(int id, int sabaq)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE students SET sabaq = "+sabaq+" WHERE id = "+id+"";
        db.execSQL(query);
    }

    public void updateSabqi(int id, int sabqi)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE students SET sabqi = "+sabqi+" WHERE id = "+id+"";
        db.execSQL(query);
    }

    public void updateManzil(int id, int manzil)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE students SET manzil = "+manzil+" WHERE id = "+id+"";
        db.execSQL(query);
    }
}
