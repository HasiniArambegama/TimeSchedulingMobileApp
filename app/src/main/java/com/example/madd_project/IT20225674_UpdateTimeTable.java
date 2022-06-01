package com.example.madd_project;

import  androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*public class IT20225674_UpdateTimeTable extends AppCompatActivity {
    TextView timeButton1, timeButton2;
    int hour1, minute1, hour2, minute2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_update_time_table);

        Spinner mySpinner = (Spinner) findViewById(R.id.Adays);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IT20225674_UpdateTimeTable.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Adays));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.Asubject);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(IT20225674_UpdateTimeTable.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Asubject));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter2);

        timeButton1 = findViewById(R.id.St_button);
        timeButton2 = findViewById(R.id.Ed_button);
        timeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        IT20225674_UpdateTimeTable.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                hour1 = selectedHour;
                                minute1 = selectedMinute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, hour1, minute1);
                                timeButton1.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(hour1, minute1);
                timePickerDialog.show();
            }
        });

        timeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        IT20225674_UpdateTimeTable.this,
                        //android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                hour2 = selectedHour;
                                minute2 = selectedMinute;
                                String time = hour2 + ":" + minute2;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    timeButton2.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, false

                );
                // timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(hour2, minute2);
                timePickerDialog.show();
            }
        });


    }
}*/
