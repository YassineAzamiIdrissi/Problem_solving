package org.example.Prob_6_matrix_queries;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        // System.out.println("Enter num of lines : ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            // System.out.println("Enter how much numbers is line " + (i + 1) + ": ");
            int num = scanner.nextInt();
            ArrayList<Integer> lineNumbers = new ArrayList<>();
            if (num == 0) {
                matrix.add(lineNumbers);
                continue;
            }
            for (int j = 0; j < num; ++j) {
                // System.out.println("Number " + (j + 1) + " in line " + (i + 1) + ": ");
                lineNumbers.add(scanner.nextInt());
            }
            matrix.add(lineNumbers);
        }
        /*System.out.println("THIS IS THE OUTPUT....");
        for (int i = 0; i < matrix.size(); i++) {
            System.out.print("Line " + (i + 1) + " --> ");
            if (matrix.get(i).isEmpty()) {
                System.out.println("  ");
                continue;
            }
            for (int j = 0; j < matrix.get(i).size(); ++j) {
                System.out.print(" " + matrix.get(i).get(j));
            }
            System.out.println();
        }*/
        // System.out.println("DEFINE QUERIES ---------------------------------- ");
        // System.out.println("How much queries do you want : ");
        int q = scanner.nextInt();
        for (int i = 0; i < q; ++i) {
            // System.out.println("couple " + (i + 1));
            ArrayList<Integer> query = new ArrayList<>();
            // System.out.println("x_" + (i + 1));
            int couple_i = scanner.nextInt();
            // System.out.println("y_" + (i + 1));
            int couple_j = scanner.nextInt();
            query.add(couple_i);
            query.add(couple_j);
            queries.add(query);
        }

        for (int i = 0; i < queries.size(); i++) {
            ArrayList<Integer> query = queries.get(i);
            Integer x = query.getFirst();
            Integer y = query.getLast();
            int x_as_index = x - 1;
            int y_as_index = y - 1;
            if (matrix.get(x_as_index).isEmpty()) {
                System.out.println("ERROR!");
            } else if (y_as_index >= n) {
                System.out.println("ERROR!");
            } else {
                ArrayList<Integer> concernedArray = matrix.get
                        (x_as_index);
                if (y_as_index >= concernedArray.size()) {
                    System.out.println("ERROR!");
                } else {
                    System.out.println(matrix.get(x_as_index).
                            get(y_as_index));
                }
            }
        }
//        for (int i = 0; i < queries.size(); i++) {
//            System.out.print("COUPLE " + (i + 1) + "   ");
//            System.out.print(queries.get(i).get(0) + "  " + queries.get(i).get(1));
//            System.out.println();
//        }
    }
}
