package org.example.Java.Prob_16_OOP_Interfaces;

import java.util.ArrayList;

public class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisor_sum(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        int sum = 0;
        for (Integer divisor : divisors) {
            sum += divisor;
        }
        return sum;
    }
    
}
