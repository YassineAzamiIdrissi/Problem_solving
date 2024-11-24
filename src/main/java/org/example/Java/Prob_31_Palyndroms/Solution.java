package org.example.Java.Prob_31_Palyndroms;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(input);
        if (sb.reverse().toString().equals(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
