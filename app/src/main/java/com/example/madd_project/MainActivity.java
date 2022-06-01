package com.example.madd_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        /*imgView = findViewById(R.id.imgv_module);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_module_page(v);
            }
        });*/

       /*imgView = findViewById(R.id.imgv_event);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_event_page(v);
            }
        });*/

        imgView = findViewById(R.id.imgv_timetable);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_timetable_page(v);
            }
        });

        imgView = findViewById(R.id.imgv_studygroup);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_studyGroup_page(v);
            }
        });

    }

    /*public void open_module_page(View view) {
        Intent intent = new Intent(this,IT20225674_Days.class);
        startActivity(intent);
    }*/

    /*public void open_event_page(View view) {
        Intent intent = new Intent(this,IT20225674_DeleteTimeTable.class);
        startActivity(intent);
    }*/

    public void open_timetable_page(View view) {
        Intent intent = new Intent(this,IT20225674_Days.class);
        startActivity(intent);

    }

    public void open_studyGroup_page(View view) {
        Intent intent = new Intent(this,IT20225674_MyViewCalendar.class);
        startActivity(intent);
    }
}