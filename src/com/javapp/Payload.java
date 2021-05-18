package com.javapp;

public class Payload {
    private String start_date;
    private String end_date;
    private String run_times;

    public Payload() {
        this.start_date = "01-02-2021";
        this.end_date = "30-03-2021";
        this.run_times = "09:00,09:10,09:20,13:04";
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRun_times() {
        return run_times;
    }

    public void setRun_times(String run_times) {
        this.run_times = run_times;
    }
}
