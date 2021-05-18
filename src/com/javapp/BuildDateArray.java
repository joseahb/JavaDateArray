package com.javapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class BuildDateArray {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date startDate;
    Date endDate;
    String run_times;
    ArrayList<String> data = new ArrayList<String>();

    public BuildDateArray (Payload payload) throws ParseException {

        this.run_times = payload.getRun_times();

        try{
            this.startDate = formatter.parse(payload.getStart_date());
            this.endDate = formatter.parse(payload.getEnd_date());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<String> fetchArray () {
        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        String[] times = run_times.split(",");

        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            for (String i : times) {

                LocalTime timePart = LocalTime.parse(i);

                LocalDateTime date_time_data = LocalDateTime.of(date, timePart);
                data.add(date_time_data.toString());
            }
        }
        return data;
    }

    public static void main(String[] args) throws ParseException {
        Payload payload = new Payload();
        BuildDateArray buildDateArray = new BuildDateArray(payload);
        
        ArrayList<String> date_data = buildDateArray.fetchArray();

        for (Object i :date_data) {
            System.out.println(i.toString());
        }
    }
}