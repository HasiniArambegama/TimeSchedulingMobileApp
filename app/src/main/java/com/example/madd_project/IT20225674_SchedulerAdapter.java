package com.example.madd_project;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/*  create basic adapter extending from FirebaseRecyclerAdapter
    adapter class fetch the data in ViewHolder class*/
public class IT20225674_SchedulerAdapter extends FirebaseRecyclerAdapter<IT20225674_ScheduleModel,IT20225674_SchedulerAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    //create constructor matching parent
    public IT20225674_SchedulerAdapter(@NonNull FirebaseRecyclerOptions<IT20225674_ScheduleModel> options) {
        super(options);
    }

    @Override
    // binds the data to the TextView in each row
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull IT20225674_ScheduleModel model) {
        holder.Day.setText(model.getDay());
        holder.Subject.setText(model.getSubject());
        holder.StartTime.setText(model.getStartTime());
        holder.EndTime.setText(model.getEndTime());

        // allows clicks events to be caught
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final DialogPlus dialogPlus = DialogPlus.newDialog(holder.Day.getContext())
                       .setContentHolder(new ViewHolder(R.layout.activity_it20225674_update_time_table))
                       .setExpanded(true, 1200)
                       .create();
               //dialogPlus.show();
                View v = dialogPlus.getHolderView();
                TextView Day = v.findViewById(R.id.Adays);
                TextView Subject = v.findViewById(R.id.Asubject);
                TextView StartTime = v.findViewById(R.id.St_button);
                TextView EndTime = v.findViewById(R.id.Ed_button);


                Button up_Button = v.findViewById(R.id.up_button);

                // Set item views based on the views and data model
                Day.setText(model.getDay());
                Subject.setText(model.getSubject());
                StartTime.setText(model.getStartTime());
                EndTime.setText(model.getEndTime());

                dialogPlus.show();

                // allows clicks events to be caught
                // and update the data
                up_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        //specified value with the specified key in the map
                        map.put("Day",Day.getText().toString());
                        map.put("Subject",Subject.getText().toString());
                        map.put("StartTime",StartTime.getText().toString());
                        map.put("EndTime", EndTime.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Timetable")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.Day.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.Day.getContext(), "Failed To Update", Toast.LENGTH_SHORT).show();
                                    }
                                });



                    }
                });
            }
        });

        // allows clicks events to be caught
        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.Subject.getContext());
                builder.setTitle("Are You Sure?");
                builder.setMessage("Deleted data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Timetable")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.Subject.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //create new views invoked by the layout manager
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.it20225674_schedule_list, parent, false);
        return new myViewHolder(view);
    }

    //create ViewHolder class
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView Day, Subject, StartTime, EndTime;

        Button btEdit, btDelete;

        //create constructor matching parent
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

         //define click listener for the ViewHolder's view
            img = (CircleImageView) itemView.findViewById(R.id.image1);
            Day = (TextView) itemView.findViewById(R.id.Liname);
            Subject = (TextView) itemView.findViewById(R.id.Lisub);
            StartTime = (TextView) itemView.findViewById(R.id.List_Stime);
            EndTime = (TextView) itemView.findViewById(R.id.List_Etime);

            btEdit = (Button) itemView.findViewById(R.id.ed_button);
            btDelete = (Button) itemView.findViewById(R.id.dlt_button);
        }


    }
}
