package com.azhar.nestedrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListMain;
    ArrayList<String> arrayList;
    LinearLayoutManager linearLayoutManager;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListMain = findViewById(R.id.rvListMain);

        arrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arrayList.add("Data Ke : " + i);
        }

        mainAdapter = new MainAdapter(this, arrayList);
        linearLayoutManager = new LinearLayoutManager(this);

        rvListMain.setLayoutManager(linearLayoutManager);
        rvListMain.setAdapter(mainAdapter);
    }
}