package org.example.Algos.Prob_12_VeryLongFactorials;

import java.math.BigInteger;

public class Notes {

    public static void main(String[] args) {
        // BigInteger is a Java Class that permits us handling very big numbers
        // we construct big integer using strings instead of int values...
        // example :
        BigInteger b = new BigInteger("1");
        BigInteger a = new BigInteger("10");
        // operations are methods withing the objects...
        BigInteger sum = a.add(b);
        BigInteger product = a.multiply(b);
        BigInteger division = a.divide(b);
        BigInteger substraction = a.subtract(b);

        System.out.println(sum);
        // some special values :
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger ten = BigInteger.TEN;
        // some other conversion :
        BigInteger five = BigInteger.valueOf(5);
        // or as we used previously :
        BigInteger fiveAgain = new BigInteger("5");
    }
}
