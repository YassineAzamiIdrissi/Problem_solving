package org.example.Prob_41_Exceptions_Handling;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int num_1 = scanner.nextInt();
            int num_2 = scanner.nextInt();
            double division = num_1 / num_2;
        } catch (Exception exp) {
            if (exp.getMessage() != null)
                System.out.println(exp.getClass().toString().split(" ")[1] + ": " + exp.getMessage());
            else
                System.out.println(exp.getClass());
        }
    }
}
