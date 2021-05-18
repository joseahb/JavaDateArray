package com.javapp;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class GetDateArray {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-y");
    Date startDate;
    Date endDate;
    String run_times;
    ArrayList<String[]> data = new ArrayList<String[]>();

    public GetDateArray (Payload payload) throws ParseException {

        this.run_times = payload.getRun_times();

        try{
            this.startDate = formatter.parse(payload.getStart_date());
            this.endDate = formatter.parse(payload.getEnd_date());
        }
        catch (Exception e) {
            throw e;
        }
    }

    public Array fetchArray () {
        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {

            String date_time_date[] = {date.toString(), run_times};
            data.add(date_time_date);
        }
        // print arrays from ArrayList
        for (String i[] : data) {
            System.out.println(Arrays.toString(i));
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        Payload payload = new Payload();
        GetDateArray getDateArray = new GetDateArray(payload);
        getDateArray.fetchArray();
    }
}