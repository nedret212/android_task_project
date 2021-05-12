package com.nedretgegeoglu.retrofit.helpers.date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {

    public static String convertTimeStamp(int timeStamp){
        Date date = new Date(timeStamp * 1000L);
        SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");

        return sf.format(date);
    }
}
