package org.example.Java.Prob_22_End_Of_File;

import java.util.Scanner;

public class Solution {
    static {
        System.out.println("Hello class");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ++num;
            System.out.println(num + " " + line);
            if (line.endsWith(".")) break;
        }
    }
}
