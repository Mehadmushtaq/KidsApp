package com.example.saqbaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText stdName, stdrollNo, stdSabaq, stdSabqi, stdManzil;
    Button addBtn,showStd;
//    ListView stdListView;

    dbHelper db;
    ArrayList<Student> list;

//    ArrayList<Students> friendArrayList = new ArrayList<Students>();
//    RecyclerView recyclerView;
//    RecyclerView.LayoutManager layoutManager;
//    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stdName = findViewById(R.id.stdName);
        stdrollNo = findViewById(R.id.stdrollNo);
        stdSabaq = findViewById(R.id.stdSabaq);
        stdSabqi = findViewById(R.id.stdSabqi);
        stdManzil = findViewById(R.id.stdManzil);
        addBtn = findViewById(R.id.addBtn);
        showStd = findViewById(R.id.showStd);

        list = new ArrayList<Student>();
        db = new dbHelper(this);

        showStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(stdName.getText().toString().equals("") || stdrollNo.getText().toString().equals("") || stdSabaq.getText().toString().equals("") || stdSabqi.getText().toString().equals("") || stdManzil.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data of Students",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = stdName.getText().toString();
                    String rollNo = stdrollNo.getText().toString();
                    int sabaq = Integer.parseInt(stdSabaq.getText().toString());
                    int sabqi = Integer.parseInt(stdSabqi.getText().toString());
                    int manzil = Integer.parseInt(stdManzil.getText().toString());

                    list.add(new Student(0,name,rollNo,sabaq,sabqi,manzil));

                    db.insert(new Student(0,name,rollNo,sabaq,sabqi,manzil));

                    stdName.setText("");
                    stdrollNo.setText("");
                    stdSabaq.setText("");
                    stdSabqi.setText("");
                    stdManzil.setText("");

                    Toast.makeText(MainActivity.this,"Students Record has been added",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}