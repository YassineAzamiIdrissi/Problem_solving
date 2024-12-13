package org.example.Algos.Prob_10_hours;

public class Solution {
    public static String timeConversion(String s) {
        String[] parts = s.split(":");
        Integer hours = Integer.parseInt(parts[0]);
        String type = parts[2].substring(2);
        if (type.equals("AM")) {
            if (hours == 12)
                return "00" + ":" + parts[1] + ":" + parts[2].substring(0, 2);
            return parts[0] + ":" + parts[1] + ":" + parts[2].substring(0, 2);
        } else {
            if (hours != 12)
                hours = 12 + hours;

            String hours__ = hours.toString();
            if (hours__.length() == 1) {
                hours__ = "0" + hours__;
            }
            return hours__ + ":" + parts[1] + ":" + parts[2].substring(0, 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:40:22AM"));
    }
}
