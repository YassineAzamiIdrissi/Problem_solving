package org.example.Algos.Problem_6_precisions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void plusMinus(List<Integer> arr) {
        int neg_occs = 0, pos_occs = 0, zero_occs = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                neg_occs++;
            } else if (arr.get(i) > 0) {
                pos_occs++;
            } else {
                zero_occs++;
            }
        }
        System.out.printf("%.5f", (double) neg_occs / arr.size());
        System.out.printf("%.5f", (double) pos_occs / arr.size());
        System.out.printf("%.5f", (double) zero_occs / arr.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        plusMinus(arr);

        bufferedReader.close();
    }
}
