package org.example.Prob_39_VarArgs;

public class Add {
    public static void add(Integer... args) {
        String[] expression = new String[2 * args.length - 1];
        int sum = 0;
        for (var element : args) {
            sum += element;
        }
        int index = 0;
        for (int i = 0; i < expression.length; i++) {
            if (i % 2 == 0) {
                expression[i] = args[index].toString();
                index++;
            } else {
                expression[i] = "+";
            }
        }
        for (int i = 0; i < expression.length; i++) {
            System.out.print(expression[i]);
        }
        System.out.print("=" + sum);
        System.out.println();
    }
}
