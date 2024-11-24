package org.example.Java.Prob_3_Hour_Glass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static ArrayList<Integer>
    formHourGlass(List<List<Integer>> arr, int i_center, int j_center) {
        ArrayList<Integer> hourGlass = new ArrayList<>();
        for (int i = j_center - 1; i <= j_center + 1; ++i) {
            hourGlass.add(arr.get(i_center - 1).get(i));
        }
        hourGlass.add(arr.get(i_center).get(j_center));
        for (int i = j_center - 1; i <= j_center + 1; ++i) {
            hourGlass.add(arr.get(i_center + 1).get(i));
        }
        return hourGlass;
    }

    public static void extractHourGlassesMax(List<List<Integer>> arr) {
        ArrayList<ArrayList<Integer>> hourGlasses = new ArrayList<>();
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                hourGlasses.add(formHourGlass(arr, i, j));
            }
        }

        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < 16; ++i) {
            int s = 0;
            for (int j = 0; j < hourGlasses.get(i).size(); j++) {
                s += hourGlasses.get(i).get(j);
            }
            System.out.println("SUM_" + i + "   " + s);
            sums.add(s);
        }

        int m = 0;
        for (int i = 0; i < sums.size(); ++i) {
            if (sums.get(i) >= sums.get(m)) {
                m = i;
            }
        }
        System.out.println("WANTEEED ::::::: ");
        System.out.println(sums.get(m));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        extractHourGlassesMax(arr);
        bufferedReader.close();
    }
}
