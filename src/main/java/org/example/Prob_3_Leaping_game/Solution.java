package org.example.Prob_3_Leaping_game;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        int currentPosition = 0;
        boolean ongoing = true;
        boolean result = false;
        if (leap > game.length - 1) {
            return true;
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        while (ongoing) {
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
                ongoing = false;
            }
            if (currentPosition == game.length - 1 && game[currentPosition] == 0) {
                return true;
            } else if (currentPosition > game.length - 1 || currentPosition + leap >
                    game.length - 1) {
                ongoing = false;
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write num of tests : : : ");

        int q = scan.nextInt();

        while (q-- > 0) {

            System.out.println("Enter array size");

            int n = scan.nextInt();

            System.out.println("Enter Leap");

            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {

                System.out.println("Write element of this array " + (i + 1));

                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
