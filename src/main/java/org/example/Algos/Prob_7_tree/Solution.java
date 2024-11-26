package org.example.Algos.Prob_7_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void staircase(int n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; ++k) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }
}
