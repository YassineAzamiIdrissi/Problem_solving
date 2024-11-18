package org.example.Prob_19_LambdaExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Predicate;

public class Solution {

    static public Predicate<Integer> isOdd() {
        return (Integer a) -> a % 2 == 1;
    }

    static public Predicate<Integer> isPrime() {
        return (Integer a) -> {
            int d = 0;
            for (int i = 1; i <= a; ++i) {
                if (a % i == 0) {
                    d++;
                }
            }
            return d == 2;
        };
    }

    static public Predicate<Integer> isPalyndrome() {
        return (Integer n) -> {
            String numText = n.toString();
            String reversedString = "";
            for (int i = numText.length() - 1; i >= 0; i--) {
                reversedString += numText.charAt(i);
            }
            return reversedString.equals(numText);
        };
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many tests you want to carry out ? ");
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            System.out.println("Input " + (i + 1));
            String[] line = reader.readLine().replaceAll(
                    "\\s+$", ""
            ).split(" ");
            int operationIndex = Integer.parseInt(line[0]);
            int numberInput = Integer.parseInt(line[1]);
            if (operationIndex == 1) {
                Predicate<Integer> function = isOdd();
                if (function.test(numberInput)) {
                    System.out.println("ODD");
                } else {
                    System.out.println("EVEN");
                }
            } else if (operationIndex == 2) {
                Predicate<Integer> function = isPrime();
                if (function.test(numberInput)) {
                    System.out.println("PRIME");
                } else {
                    System.out.println("COMPOSITE");
                }
            } else if (operationIndex == 3) {
                Predicate<Integer> function = isPalyndrome();
                if (function.test(numberInput)) {
                    System.out.println("PALINDROME");
                } else {
                    System.out.println("NOT PALINDROME");
                }
            } else {
                System.out.println("This index doesn't correspond to any of the " +
                        "existing operations ");
            }
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
