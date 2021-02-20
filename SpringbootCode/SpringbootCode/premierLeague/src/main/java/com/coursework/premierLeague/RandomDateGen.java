package com.coursework.premierLeague;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDateGen {

    public static int randomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String createRandomDate(int start, int end) throws ParseException {
        int day = randomIntBetween(1, 28);
        int month = randomIntBetween(1, 12);
        int year = randomIntBetween(start, end);
        String strday = String.format("%02d", day);
        String strmonth = String.format("%02d", month);

        String dateFormat = strmonth+"-"+strday+"-"+year;


        return dateFormat;

    }


}