package org.example.Java.Prob_40_BigIntegers_sum_product;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num_1 = scanner.nextLine();
        String num_2 = scanner.nextLine();
        BigInteger num_1_ = new BigInteger(num_1);
        BigInteger num_2_ = new BigInteger(num_2);
        System.out.println(num_2_.add(num_1_));
        System.out.println(num_2_.multiply(num_1_));
    }
}
