package org.example.Prob_30_Substrings_comparison;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        ArrayList<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + k > s.length()) break;
            String concerned = s.substring(i, i + k);
            subs.add(concerned);
        }
        int max_element = 0, min_element = 0;
        for (int i = 1; i < subs.size(); i++) {
            if (subs.get(i).compareTo(subs.get(max_element)) >= 0) {
                max_element = i;
            }
            if (subs.get(i).compareTo(subs.get(min_element)) <= 0) {
                min_element = i;
            }
        }
        largest = subs.get(max_element);
        smallest = subs.get(min_element);
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
