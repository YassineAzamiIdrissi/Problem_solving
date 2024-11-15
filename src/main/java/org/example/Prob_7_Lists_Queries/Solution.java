package org.example.Prob_7_Lists_Queries;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("Array size :: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + (i + 1));
            array.add(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("Defining queries ::: ::: ");
        System.out.println("Number of queries ");
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; ++i) {
            System.out.println("Define query " + (i + 1));
            String operation = scanner.nextLine();
            if (operation.equals("Insert")) {
                System.out.println("Define position : ");
                int position = Integer.parseInt(scanner.nextLine());
                System.out.println("Define number : ");
                int number = Integer.parseInt(scanner.nextLine());
                array.add(number);
                int temp;
                temp = array.get(position);
                array.set(position, array.get(array.size() - 1));
                array.set(array.size() - 1, temp);
            } else if (operation.equals("Delete")) {
                System.out.println("Define a position : ");
                int position = Integer.parseInt(scanner.nextLine());
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < array.size(); ++j) {
                    if (j != position) {
                        temp.add(array.get(j));
                    }
                }
                array = temp;
            }
        }
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(array.get(i) + " ");
        }
        scanner.close();
    }
}
