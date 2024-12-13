package org.example.Algos.Prob_11_MagicSquare;

import java.util.List;
import java.util.Scanner;

class Solution {

    private static final int[][][] MAGIC_SQUARES =
            {
                    {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                    {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                    {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                    {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                    {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                    {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                    {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                    {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}
            };

    private static int distance(List<List<Integer>> s, int[][] square) {
        int d = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                d += Math.abs(square[i][j] - s.get(i).get(j));
            }
        }
        return d;
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int minDistance = Integer.MAX_VALUE;
        for (int[][] magicSquare : MAGIC_SQUARES) {
            int dist = distance(s, magicSquare);
            minDistance = Math.min(minDistance, dist);
        }
        return minDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }
}
