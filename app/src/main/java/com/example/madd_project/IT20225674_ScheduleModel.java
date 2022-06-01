package com.example.madd_project;

public class IT20225674_ScheduleModel {
    String Day, Subject, StartTime, EndTime;

    //default constructor
    IT20225674_ScheduleModel()
    {

    }

    //overloaded constructor
    public IT20225674_ScheduleModel(String day, String subject, String startTime, String endTime) {
        Day = day;
        Subject = subject;
        StartTime = startTime;
        EndTime = endTime;
    }

    //set getters and setters

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
