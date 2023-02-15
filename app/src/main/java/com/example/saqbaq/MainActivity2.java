package com.example.saqbaq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Student> friendArrayList = new ArrayList<Student>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    dbHelper db;
//    ArrayList<Students> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        list = new ArrayList<Students>();
        db = new dbHelper(this);

        friendArrayList  = db.getStudents();
//        friendArrayList.addAll(Arrays.asList(new Friend[]{f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11}));

        recyclerView = findViewById(R.id.recylerViewStudent);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity2.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false); //(context,orientation,reverseLayout);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(friendArrayList);
        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }
}