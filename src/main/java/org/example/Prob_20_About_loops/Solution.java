package org.example.Prob_20_About_loops;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args)
            throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= q; i++) {
            int a = Integer.parseInt(scanner.next());
            int b = Integer.parseInt(scanner.next());
            int n = Integer.parseInt(scanner.next());

            int sum = a;
            for (int j = 0; j < n; ++j) {
                sum += (int) Math.pow(2, j) * b;
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
