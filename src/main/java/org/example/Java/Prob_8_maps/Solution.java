package org.example.Java.Prob_8_maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argh) {
        Map<String, Long> book = new HashMap<>();
        Scanner in = new Scanner(System.in);
        // System.out.println("Insert a number :: ");
        long n = in.nextLong();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            // System.out.println("Insert a name :: ");
            String name = in.nextLine();
            // System.out.println("Insert a phone :: ");
            Long phone = in.nextLong();
            book.put(name, phone);
            in.nextLine();
        }
        ArrayList<String> queries = new ArrayList<>();
        while (in.hasNextLine()) {
            String query = in.nextLine();
            if (query.isEmpty()) break;
            if (book.containsKey(query)) {
                System.out.println(query + "=" + book.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}

