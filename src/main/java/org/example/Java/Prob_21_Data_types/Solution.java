package org.example.Java.Prob_21_Data_types;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        short minShort = Short.MIN_VALUE;
        int maxInteger = Integer.MAX_VALUE;
        int minInteger = Integer.MIN_VALUE;
        int tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= tests; i++) {
            String input = scanner.nextLine();
            try {
                long number = Long.parseLong(input);
                System.out.print(number + " can be fitted in: \n");
                if (number >= minByte && number <= maxByte) {
                    System.out.println("* byte");
                }
                if (number >= minShort && number <= maxShort) {
                    System.out.println("* short");
                }
                if (number >= minInteger && number <= maxInteger) {
                    System.out.println("* int");
                }
                System.out.println("* long");
            } catch (Exception e) {
                System.out.println(input + " can't be fitted anywhere.");
            }
        }
    }
}
