package org.example.Java.Prob_41_Exceptions_Handling;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = "";
        try {
            Integer num_1 = scanner.nextInt();
            // temp = num_1.toString();
            Integer num_2 = scanner.nextInt();
            int division = num_1 / num_2;
            System.out.println(division);
        } catch (Exception exp) {
            if (exp.getMessage() != null) {
                if (exp instanceof ArithmeticException) {
                    System.out.println(exp.getClass().toString().split(" ")[1] + ": " +
                            exp.getMessage());
                } else
                    System.out.println(exp.getClass().toString().split(" ")[1]);
            } else
                System.out.println(exp.getClass().toString().split(" ")[1]);
        }
    }
}
