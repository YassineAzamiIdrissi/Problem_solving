package org.example.Java.Prob_36_Tag_Based_Languages;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String regex = "^(<*>*</*>)$";
        while (testCases > 0) {
            String line = in.nextLine();
            String[] parts = line.split(regex);
            for (int i = 0; i < parts.length; i++) {
                System.out.println(parts[i]);
            }
            testCases--;
        }
    }
}
