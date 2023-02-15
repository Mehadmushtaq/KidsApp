package com.example.saqbaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView nameTextView,rollNoTextView,sabaqTextView,sabqiTextView,manzilTextView;
    Button sabaqBtn,sabqiBtn,manzilBtn,nextParaBtn;

    dbHelper db;
    Student std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db = new dbHelper(this);

        nameTextView  = findViewById(R.id.nameTextView);
        rollNoTextView  = findViewById(R.id.rollNoTextView);
        sabaqTextView  = findViewById(R.id.sabaqTextView);
        sabqiTextView  = findViewById(R.id.sabqiTextView);
        manzilTextView  = findViewById(R.id.manzilTextView);
        sabaqBtn  = findViewById(R.id.sabaqBtn);
        sabqiBtn  = findViewById(R.id.sabqiBtn);
        manzilBtn  = findViewById(R.id.manzilBtn);
        nextParaBtn  = findViewById(R.id.nextParaBtn);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        String name = intent.getStringExtra("Name");
        String rollNo = intent.getStringExtra("RollNo");
        int sabaq = intent.getIntExtra("Sabaq",0);
        int sabqi = intent.getIntExtra("Sabqi",0);
        int manzil = intent.getIntExtra("Manzil",0);

        std = new Student(id,name,rollNo,sabaq,sabqi,manzil);

//        Log.d("checkid",String.valueOf(id));
//        Log.d("checkname",name);
//        Log.d("checkrollno",rollNo);
//        Log.d("checksabaq",String.valueOf(sabaq));
//        Log.d("checksabqi",String.valueOf(sabqi));
//        Log.d("checkmanzil",String.valueOf(manzil));

        nameTextView.setText(name);
        rollNoTextView.setText(rollNo);
        sabaqTextView.setText(String.valueOf(sabaq));
        sabqiTextView.setText(String.valueOf(sabqi));
        manzilTextView.setText(String.valueOf(manzil));

        sabaqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student dbstd = db.getStudent(std.getId());

                if(dbstd.getSabaq() == 0)
                {
                    db.updateSabaq(std.getId(),1);
                }
                Toast.makeText(MainActivity3.this, "Student has recited his sabaq.", Toast.LENGTH_SHORT).show();

                Student st = db.getStudent(std.getId());

                nameTextView.setText(st.getName());
                rollNoTextView.setText(st.getRollNo());
                sabaqTextView.setText(String.valueOf(st.getSabaq()));
                sabqiTextView.setText(String.valueOf(st.getSabqi()));
                manzilTextView.setText(String.valueOf(st.getManzil()));
            }
        });

        nextParaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student dbstd = db.getStudent(std.getId());
                if(dbstd.getSabaq() == 0)
                {
                    db.updateSabaq(dbstd.getId(),1);
                }

                dbstd = db.getStudent(std.getId());
                if(dbstd.getSabaq()<=29)
                {
                    int newSabaq = dbstd.getSabaq() + 1;
                    db.updateSabaq(std.getId(),newSabaq);
                }
                else if(dbstd.getSabaq()==30)
                {
                    db.updateSabaq(std.getId(),1);
                }
                Toast.makeText(MainActivity3.this, "Student is on next para now.", Toast.LENGTH_SHORT).show();

                Student st = db.getStudent(std.getId());
                nameTextView.setText(st.getName());
                rollNoTextView.setText(st.getRollNo());
                sabaqTextView.setText(String.valueOf(st.getSabaq()));
                sabqiTextView.setText(String.valueOf(st.getSabqi()));
                manzilTextView.setText(String.valueOf(st.getManzil()));
            }
        });

        sabqiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student dbstd = db.getStudent(std.getId());
                if(dbstd.getSabaq() == 0)
                {
                    db.updateSabaq(std.getId(),1);
                }
                dbstd = db.getStudent(std.getId());
                int mySabqi = dbstd.getSabaq()-1;
                db.updateSabqi(std.getId(),mySabqi);

                Toast.makeText(MainActivity3.this, "Student has recited his sabqi.", Toast.LENGTH_SHORT).show();

                Student st = db.getStudent(std.getId());
                nameTextView.setText(st.getName());
                rollNoTextView.setText(st.getRollNo());
                sabaqTextView.setText(String.valueOf(st.getSabaq()));
                sabqiTextView.setText(String.valueOf(st.getSabqi()));
                manzilTextView.setText(String.valueOf(st.getManzil()));
            }
        });

        manzilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student dbstd = db.getStudent(std.getId());
                if(dbstd.getSabaq() == 0)
                {
                    db.updateSabaq(std.getId(),1);
                }
                dbstd = db.getStudent(std.getId());
                if(dbstd.getSabqi() == dbstd.getManzil())
                {
                    if(dbstd.getSabqi() == 0)
                    {
                        db.updateManzil(std.getId(),0);
                    }
                    else
                    {
                        int myManzil = 1;
                        db.updateManzil(std.getId(),myManzil);
                    }
                }
                else
                {
                    int myManzil = dbstd.getManzil()+1;
                    db.updateManzil(std.getId(),myManzil);
                }

                Toast.makeText(MainActivity3.this, "Student has recited his manzil.", Toast.LENGTH_SHORT).show();

                Student st = db.getStudent(std.getId());
                nameTextView.setText(st.getName());
                rollNoTextView.setText(st.getRollNo());
                sabaqTextView.setText(String.valueOf(st.getSabaq()));
                sabqiTextView.setText(String.valueOf(st.getSabqi()));
                manzilTextView.setText(String.valueOf(st.getManzil()));
            }
        });


    }
}