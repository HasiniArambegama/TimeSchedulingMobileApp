package com.example.madd_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IT20225674_Days extends AppCompatActivity {
    Button buttonD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_days);
        buttonD = (Button)findViewById(R.id.btnd1);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IT20225674_Days.this,IT20225674_ViewSchedule.class);
                startActivity(intent);
                finish();
            }
        });
    }
}