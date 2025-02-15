package org.example.Algos.Prob_12_VeryLongFactorials;

import java.math.BigInteger;

public class Result {
    public static void extraLongFactorials(Integer n) {
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
