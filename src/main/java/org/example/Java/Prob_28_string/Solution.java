package org.example.Java.Prob_28_string;

import java.util.Scanner;

public class Solution {
    static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = capitalize(sc.next());
        String B = capitalize(sc.next());
        String resp = "";
        // char f_a = A.charAt(0);
        // char f_b = B.charAt(0);

        int diffIndex = 0;
        for (int i = 0; i < Math.min(B.length(), A.length()); i++) {
            if (B.charAt(i) != A.charAt(i)) {
                diffIndex = i;
                break;
            }
        }
        if (B.charAt(diffIndex) < A.charAt(diffIndex)) {
            resp = "Yes";
        } else {
            resp = "No";
        }
        System.out.println(A.length() + B.length());
        System.out.println(resp);
        System.out.println(A + " " + B);
    }
}
