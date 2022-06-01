package com.example.madd_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.DataFormatException;

public class IT20225674_AddTimeTable extends AppCompatActivity {
    TextView timeButton1, timeButton2;
    int hour1, minute1, hour2, minute2;
    Spinner Day,Subject;
    Button sv_button, bk_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_add_time_table);

        Spinner mySpinner = (Spinner) findViewById(R.id.Adays);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IT20225674_AddTimeTable.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Adays));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.Asubject);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(IT20225674_AddTimeTable.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Asubject));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter2);

        timeButton1 = findViewById(R.id.St_button);
        timeButton2 = findViewById(R.id.Ed_button);
        timeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        IT20225674_AddTimeTable.this,
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
                        IT20225674_AddTimeTable.this,
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
        /*findViewById(R.id.sv_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(IT20225674_AddTimeTable.this)
                        //on(R.drawable.ic_warning_it20225674)
                        .setTitle("Save")
                        .setMessage("Are you sure to save this?")
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();

            }
        });*/

        Day = (Spinner)findViewById(R.id.Adays);
        Subject = (Spinner) findViewById(R.id.Asubject);

        sv_button = (Button)findViewById(R.id.sv_button);
        bk_button = (Button)findViewById(R.id.bk_button);

        sv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        bk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IT20225674_AddTimeTable.this, IT20225674_ViewSchedule.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }


    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        //specified value with the specified key in the map
        map.put("Day",Day.getSelectedItem().toString());
        map.put("Subject",Subject.getSelectedItem().toString());
        map.put("StartTime",timeButton1.getText().toString());
        map.put("EndTime",timeButton2.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Timetable").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(IT20225674_AddTimeTable.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(IT20225674_AddTimeTable.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}