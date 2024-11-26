package org.example.Algos.Problem_8_maxmin_four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void miniMaxSum(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        long min = 0, max = 0;
        for (int i = 1; i < arr.size(); i++) {
            max += arr.get(i);
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            min += arr.get(i);
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        miniMaxSum(arr);

        bufferedReader.close();
    }
}
