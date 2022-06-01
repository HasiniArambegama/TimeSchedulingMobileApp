package com.example.madd_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class IT20225674_MyCalendar extends AppCompatActivity {

        EditText cName;
        EditText cTime;
        Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_my_calendar);
        cName = (EditText)findViewById(R.id.calName);
        cTime = (EditText) findViewById(R.id.calTime);

        add = (Button)findViewById(R.id.cal_button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void insertDataCal()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("cName", cName.getText().toString());
        map.put("cTime", cTime.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("Calendar").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(IT20225674_MyCalendar.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(IT20225674_MyCalendar.this, "Failed to insert", Toast.LENGTH_SHORT).show();
                    }
                });
    }




    }

