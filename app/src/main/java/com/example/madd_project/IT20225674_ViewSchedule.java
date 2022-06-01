package com.example.madd_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class IT20225674_ViewSchedule extends AppCompatActivity {

    RecyclerView recyclerView;
    IT20225674_SchedulerAdapter it20225674_schedulerAdapter;

    FloatingActionButton floatingActionButton;


    @Override
    //onCreate call when the activity is starting
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide top action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_it20225674_view_schedule);

        recyclerView = (RecyclerView) findViewById(R.id.rV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*Retrieve data
        and IT20225674_ScheduleModel is a class that get and set Strings from Firebase database*/
        FirebaseRecyclerOptions<IT20225674_ScheduleModel> options =
                new FirebaseRecyclerOptions.Builder<IT20225674_ScheduleModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Timetable"), IT20225674_ScheduleModel.class)
                        .build();

        it20225674_schedulerAdapter = new IT20225674_SchedulerAdapter(options);
        recyclerView.setAdapter(it20225674_schedulerAdapter);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),IT20225674_AddTimeTable.class));
            }
        });

    }

    @Override
    //when activity start getting visible to user by onStart method
    protected void onStart() {
        super.onStart();
        it20225674_schedulerAdapter.startListening();
    }

    @Override
    //use onStop method stop API calls
    protected void onStop() {
        super.onStop();
        it20225674_schedulerAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       SearchView searchView =(SearchView)findViewById(R.id.sV);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                textSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                textSearch(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void textSearch(String str)
    {
        //IT20225674_ScheduleModel is a class that get and set Strings from Firebase database
        //order results by the value of specified child key
        FirebaseRecyclerOptions<IT20225674_ScheduleModel> options =
                new FirebaseRecyclerOptions.Builder<IT20225674_ScheduleModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Timetable").orderByChild("Day").startAt(str).endAt(str+ "\uf8ff"), IT20225674_ScheduleModel.class)
                        .build();

        it20225674_schedulerAdapter = new IT20225674_SchedulerAdapter(options);
        it20225674_schedulerAdapter.startListening();
        recyclerView.setAdapter(it20225674_schedulerAdapter);
    }
}