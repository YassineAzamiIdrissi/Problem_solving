package org.example.Java.Prob_35_IP_Address_Regex;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}