package org.example.Prob_5_SubArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void displayArray(ArrayList<Integer> array) {
        System.out.print("{ ");
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.print(" }");
    }

    public static ArrayList<ArrayList<Integer>> writeSubArrays
            (ArrayList<Integer> array, int card) {
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (i + card <= array.size()) {
                ArrayList<Integer> subArray = new ArrayList<>();
                for (int j = i; j <= i + card - 1; ++j) {
                    subArray.add(array.get(j));
                }
                subArrays.add(subArray);
            }
        }
        return subArrays;
    }

    public static Integer numOfNegativeSubArrays(
            ArrayList<Integer> array
    ) {
        ArrayList<Integer> sums = new ArrayList<>();
        int negatives = 0;
        for (int i = 1; i <= array.size(); i++) {
            ArrayList<ArrayList<Integer>> subArrays = writeSubArrays(array, i);
            for (int j = 0; j < subArrays.size(); ++j) {
                int s = 0;
                for (int k = 0; k < subArrays.get(j).size(); k++) {
                    s += subArrays.get(j).get(k);
                }
                sums.add(s);
            }
        }
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) < 0) {
                negatives++;
            }
        }
        return negatives;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + " : ");
            array.add(sc.nextInt());
        }
        System.out.println(numOfNegativeSubArrays(array));
    }
}
