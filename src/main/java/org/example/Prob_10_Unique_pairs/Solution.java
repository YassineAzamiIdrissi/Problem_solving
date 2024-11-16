package org.example.Prob_10_Unique_pairs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        // Write your code here
        Set<String> fullNames = new HashSet<>();
        for (int i = 0; i < t; i++) {
            fullNames.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(fullNames.size());
        }
    }
}
