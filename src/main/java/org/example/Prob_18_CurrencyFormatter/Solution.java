package org.example.Prob_18_CurrencyFormatter;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        Locale usLocal = Locale.US;
        Locale inLocal = new Locale("en", "IN");
        Locale frLocale = Locale.FRANCE;
        Locale chinaLocale = Locale.CHINA;
        NumberFormat formatter = null;
        formatter = NumberFormat.getCurrencyInstance(usLocal);
        String us = formatter.format(payment);
        formatter = NumberFormat.getCurrencyInstance(inLocal);
        String india = formatter.format(payment);
        formatter = NumberFormat.getCurrencyInstance(frLocale);
        String france = formatter.format(payment);
        formatter = NumberFormat.getCurrencyInstance(chinaLocale);
        String china = formatter.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}
