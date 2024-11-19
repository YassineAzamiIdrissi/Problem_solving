package org.example.Prob_26_Calender_and_dates;

import java.util.Calendar;

public class Result {
    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        String lil_day = calendar.getTime().toString().substring(0, 3);
        switch (lil_day) {
            case "Mon":
                return "Monday".toUpperCase();
            case "Tue":
                return "Tuesday".toUpperCase();
            case "Wed":
                return "Wednesday".toUpperCase();
            case "Thu":
                return "Thursday".toUpperCase();
            case "Fri":
                return "Friday".toUpperCase();
            case "Sat":
                return "Saturday".toUpperCase();
            case "Sun":
                return "Sunday".toUpperCase();
            default:
                return "";
        }
    }
}
