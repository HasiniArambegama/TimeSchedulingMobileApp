package com.example.madd_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.madd_project.R;

public class IT20225674_Display_Weekdays extends AppCompatActivity {

    //Button btnD1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_display_weekdays);

       /* btnD1 = (Button)findViewById(R.id.btnday1);

        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, );
                startActivity(intent);
                finish();
            }
        });*/

    }
}