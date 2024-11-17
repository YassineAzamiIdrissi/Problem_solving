package org.example.Prob_13_Bitsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    static BitSet B1, B2;

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrRowTempItems = reader.readLine().replaceAll
                ("\\s+$", "").split(" ");
        int n = Integer.parseInt(arrRowTempItems[0]);
        int operations = Integer.parseInt(arrRowTempItems[1]);
        B1 = new BitSet(n);
        B2 = new BitSet(n);
        for (int i = 0; i < operations; i++) {
            String[] parts = reader.readLine().
                    replaceAll("\\s+$", "").
                    split(" ");
            String operand = parts[0];
            int index1 = Integer.parseInt(parts[1]);
            int index2 = Integer.parseInt(parts[2]);
            if (operand.equals("AND")) {
                if (index1 == 1) {
                    B1.and(B2);
                } else if (index1 == 2) {
                    B2.and(B1);
                }
            } else if (operand.equals("OR")) {
                if (index1 == 1) {
                    B1.or(B2);
                } else {
                    B2.or(B1);
                }
            } else if (operand.equals("XOR")) {
                if (index1 == 1) {
                    B1.xor(B2);
                } else {
                    B2.xor(B1);
                }
            } else if (operand.equals("SET")) {
                if (index1 == 1) {
                    B1.set(index2);
                } else if (index2 == 1) {
                    B2.set(index1);
                }
            } else if (operand.equals("FLIP")) {
                if (index1 == 1) {
                    B1.flip(index2);
                } else if (index1 == 2) {
                    B2.flip(index1);
                }
            }
            System.out.println(B1.cardinality() + " " +
                    B2.cardinality());
        }
    }
}
