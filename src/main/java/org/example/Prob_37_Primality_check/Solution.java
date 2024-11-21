package org.example.Prob_37_Primality_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger bint = new BigInteger(n);
        if (bint.isProbablePrime(5)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
        bufferedReader.close();
    }
}
