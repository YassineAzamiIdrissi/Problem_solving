package org.example.Prob_33_Substrings;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (s.trim().isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] parts = s.trim().split("[, @!'_.?]+");
        System.out.println(s.trim().length());
        System.out.println(parts.length);
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
        scan.close();
    }
}