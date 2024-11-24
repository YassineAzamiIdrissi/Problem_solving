package org.example.Java.Prob_23_static_vars;

import java.util.Scanner;

public class Solution {
    static int B, H;

    static {
        Scanner scanner = new Scanner(System.in);
        try {
            B = scanner.nextInt();
            scanner.nextLine();
            H = scanner.nextInt();
            scanner.nextLine();
            if (B <= 0 || H <= 0) {
                throw new Exception();
            }
        } catch (Exception exp) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (B * H > 0 && H > 0) {
            System.out.println(B * H);
        }
    }
}
