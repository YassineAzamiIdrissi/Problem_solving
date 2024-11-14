package org.example.Prob_4_Leaping_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        int currentPosition = 0;
        if (leap > game.length - 1) {
            return true;
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        while (true) {
            if (game[currentPosition + leap] == 0 &&
                    !indexes.contains(currentPosition + leap)) {
                currentPosition += leap;
                indexes.add(currentPosition);
            } else if (game[currentPosition + 1] == 0 &&
                    !indexes.contains(currentPosition + 1)) {
                currentPosition++;
                indexes.add(currentPosition);
            } else if (currentPosition > 0 && game[currentPosition - 1] == 0
                    && !indexes.contains(currentPosition - 1)) {
                currentPosition--;
                indexes.add(currentPosition);
            } else {
                return false;
            }
            if (currentPosition + leap > game.length - 1) {
                return true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write num of tests : : : ");

        int q = scan.nextInt();

        while (q-- > 0) {

            System.out.println("Enter array size");

            int n = scan.nextInt();

            System.out.println("Enter Leap");

            int leap = scan.nextInt();

            int[] game = new int[n];
            System.out.println("Insert this array : ");

            String[] arrRowTempItems = reader.readLine().
                    replaceAll("\\s+$", "").split(" ");
            for (int i = 0; i < n; i++) {
                game[i] = Integer.parseInt(arrRowTempItems[i]);
            }
            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
