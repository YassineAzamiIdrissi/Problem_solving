package org.example.Algos.Prob_5_matrix_Diagonals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int d_1 = 0, d_2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            d_1 += arr.get(i).get(i);
            d_2 += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(d_2 - d_1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
