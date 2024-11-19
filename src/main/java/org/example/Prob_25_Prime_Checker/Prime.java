package org.example.Prob_25_Prime_Checker;

public class Prime {
    public void checkPrime(int... numbers) {
        for (int prime : numbers) {
            int d = 0;
            for (int i = 1; i <= prime; i++) {
                if (prime % i == 0) {
                    d++;
                }
            }
            if (d == 2) {
                System.out.print(prime + " ");
            }
        }
        System.out.println();
    }
}
