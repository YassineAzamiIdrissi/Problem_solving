package org.example.Java.Prob_7_Lists_Queries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void displayArray(ArrayList<Integer> list) {
        for (var element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().replaceAll("\\s+$", "").
                split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < parts.length; ++i) {
            list.add(Integer.parseInt(parts[i]));
        }
        int queries = Integer.parseInt(reader.readLine());
        for (int i = 0; i < queries; i++) {
            String query = reader.readLine();
            if (query.equals("Insert")) {
                String[] coordinates = reader.readLine().replaceAll
                                ("\\s+$", "").
                        split(" ");
                list.add(Integer.parseInt(coordinates[0]),
                        Integer.parseInt(coordinates[1]));
            } else {
                int index = Integer.parseInt(reader.readLine());
                list.remove(index);
            }
        }
        displayArray(list);
    }
}
