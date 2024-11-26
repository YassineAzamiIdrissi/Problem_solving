package org.example.Java.ProbIlyas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class NumDetails {
    int i, j, i_voisin, j_voisin;

    public NumDetails(int i, int j, int i_voisin, int j_voisin) {
        this.i = i;
        this.j = j;
        this.i_voisin = i_voisin;
        this.j_voisin = j_voisin;
    }
}

public class Solution2 {
    public static List<NumDetails> extractCandidates(int[][] matrix) {
        int n = matrix.length;
        List<NumDetails> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] min_coordinates = findMinVoisin(matrix, i, j);
                if (matrix[i][j] <= -matrix[min_coordinates[0]][min_coordinates[1]]) {
                    NumDetails detail = new NumDetails(i, j,
                            min_coordinates[0],
                            min_coordinates[1]);
                    candidates.add(detail);
                }
            }
        }
        return candidates;
    }

    public static boolean isModifiable(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; ++j) {
                int[] min_coordinates = findMinVoisin(matrix, i, j);
                if (matrix[i][j] < 0 &&
                        matrix[i][j] < -matrix[min_coordinates[0]][min_coordinates[1]]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int positives = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] >= 0) {
                    positives++;
                    sum += matrix[i][j];
                }
            }
        }
        if (positives == n * n) {
            return sum;
        }
        do {
            List<NumDetails> candidates = extractCandidates(matrix);
            int min = 0;
            for (int i = 0; i < candidates.size(); ++i) {
                NumDetails detail_i = new NumDetails(
                        candidates.get(i).i,
                        candidates.get(i).j,
                        candidates.get(i).i_voisin,
                        candidates.get(i).j_voisin
                );
                NumDetails detail_current = new NumDetails(
                        candidates.get(min).i,
                        candidates.get(min).j,
                        candidates.get(min).i_voisin,
                        candidates.get(min).j_voisin
                );
                int dist_i = matrix[detail_i.i][detail_i.j] +
                        matrix[detail_i.i_voisin][detail_i.j_voisin];
                int dist_current = matrix[detail_current.i][detail_current.j] +
                        matrix[detail_current.i_voisin][detail_current.j_voisin];
                if (dist_i <= dist_current) {
                    min = i;
                }
            }
            matrix = modifyMatrix(matrix, candidates.get(min));

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------");
        } while (isModifiable(matrix));
//        while (isModifiable(matrix)) {
//            List<NumDetails> candidates = extractCandidates(matrix);
//            System.out.println("Those are the candidates : ");
//            for (int i = 0; i < candidates.size(); ++i) {
//                System.out.println(candidates.get(i).i + "  " + candidates.get(i).j);
//            }
//            System.out.println("-----------------------------");
//            int min = 0;
//            for (int i = 0; i < candidates.size(); ++i) {
//                NumDetails detail_i = new NumDetails(
//                        candidates.get(i).i,
//                        candidates.get(i).j,
//                        candidates.get(i).i_voisin,
//                        candidates.get(i).j_voisin
//                );
//                NumDetails detail_current = new NumDetails(
//                        candidates.get(min).i,
//                        candidates.get(min).j,
//                        candidates.get(min).i_voisin,
//                        candidates.get(min).j_voisin
//                );
//                int dist_i = matrix[detail_i.i][detail_i.j] +
//                        matrix[detail_i.i_voisin][detail_i.j_voisin];
//                int dist_current = matrix[detail_current.i][detail_current.j] +
//                        matrix[detail_current.i_voisin][detail_current.j_voisin];
//                if (dist_i <= dist_current) {
//                    min = i;
//                }
//            }
//            matrix = modifyMatrix(matrix, candidates.get(min));
//        }
        // OLD ::::::::::::: ::::::::::::::::: :::::::::::::::: ::::::::::::::::
        int ult_sum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + " ");
                ult_sum += matrix[i][j];
            }
            System.out.println();
        }
        return ult_sum;
    }

    private static int[][] modifyMatrix(int[][] matrix, NumDetails numDetails) {
        System.out.println("MODIFICATION AT " + numDetails.i + " " +
                numDetails.j + " VOISIN " + numDetails.i_voisin + " " + numDetails.j_voisin);
        matrix[numDetails.i][numDetails.j] *= -1;
        matrix[numDetails.i_voisin][numDetails.j_voisin] *= -1;
        return matrix;
    }
//    private static void modifyMinVoisin(int[][] matrice, int i, int j) {
//        int n = matrice.length;
//        int i_min = 0, j_min = 0;
//        if (i == 0 && j == 0) {
//            // voisins.add(matrice[0][1]);
//            // voisins.add(matrice[1][0]);
//            if (Math.min(matrice[0][1], matrice[1][0]) == matrice[0][1]) {
//                i_min = 0;
//                j_min = 1;
//            } else {
//                i_min = 1;
//                j_min = 0;
//            }
//        } else if (i == 0 && j == n - 1) {
//            // voisins.add(matrice[0][n - 2]);
//            // voisins.add(matrice[1][n - 1]);
//            if (Math.min(matrice[0][n - 2], matrice[1][n - 1]) == matrice[0][n - 2]) {
//                i_min = 0;
//                j_min = n - 2;
//            } else {
//                i_min = 1;
//                j_min = n - 1;
//            }
//        } else if (i == n - 1 && j == 0) {
//            // voisins.add(matrice[n - 2][0]);
//            // voisins.add(matrice[n - 1][1]);
//            if (Math.min(matrice[n - 2][0], matrice[n - 1][1]) == matrice[n - 2][0]) {
//                i_min = n - 2;
//                j_min = 0;
//            } else {
//                i_min = n - 1;
//                j_min = 1;
//            }
//        } else if (i == n - 1 && j == n - 1) {
//            // voisins.add(matrice[n - 1][n - 2]);
//            // voisins.add(matrice[n - 2][n - 1]);
//            if (Math.min(matrice[n - 1][n - 2], matrice[n - 2][n - 1]) == matrice[n - 1][n - 2]) {
//                i_min = n - 1;
//                j_min = n - 2;
//            } else {
//                i_min = n - 2;
//                j_min = n - 1;
//            }
//        } else if (i == 0) {
//            // voisins.add(matrice[i][j - 1]);
//            // voisins.add(matrice[i][j + 1]);
//            // voisins.add(matrice[i + 1][j]);
//            int temp_min = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
//            if (temp_min <= matrice[i + 1][j]) {
//                if (temp_min == matrice[i][j - 1]) {
//                    i_min = i;
//                    j_min = j - 1;
//                } else {
//                    i_min = i;
//                    j_min = j + 1;
//                }
//            } else {
//                i_min = i + 1;
//                j_min = j;
//            }
//        } else if (i == n - 1) {
//            // voisins.add(matrice[i][j - 1]);
//            // voisins.add(matrice[i][j + 1]);
//            // voisins.add(matrice[i - 1][j]);
//            int temp_min = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
//            if (temp_min <= matrice[i + 1][j]) {
//                if (temp_min == matrice[i][j - 1]) {
//                    i_min = i;
//                    j_min = j - 1;
//                } else {
//                    i_min = i;
//                    j_min = j + 1;
//                }
//            } else {
//                i_min = i - 1;
//                j_min = j;
//            }
//        } else if (j == 0) {
//            // voisins.add(matrice[i - 1][j]);
//            // voisins.add(matrice[i + 1][j]);
//            // voisins.add(matrice[i][j + 1]);
//            int temp_min = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
//            if (temp_min <= matrice[i][j + 1]) {
//                if (temp_min == matrice[i - 1][j]) {
//                    i_min = i - 1;
//                    j_min = j;
//                } else {
//                    i_min = i + 1;
//                    j_min = j;
//                }
//            } else {
//                i_min = i;
//                j_min = j + 1;
//            }
//        } else if (j == n - 1) {
//            // voisins.add(matrice[i - 1][j]);
//            // voisins.add(matrice[i + 1][j]);
//            // voisins.add(matrice[i][j - 1]);
//            int temp_min = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
//            if (temp_min <= matrice[i][j - 1]) {
//                if (temp_min == matrice[i - 1][j]) {
//                    i_min = i - 1;
//                    j_min = j;
//                } else {
//                    i_min = i + 1;
//                    j_min = j;
//                }
//            } else {
//                i_min = i;
//                j_min = j - 1;
//            }
//        } else {
//            // voisins.add(matrice[i - 1][j]);
//            // voisins.add(matrice[i + 1][j]);
//            // voisins.add(matrice[i][j - 1]);
//            // voisins.add(matrice[i][j + 1]);
//            int min_1 = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
//            int min_2 = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
//            int fin_min = Math.min(min_1, min_2);
//            if (fin_min == matrice[i - 1][j]) {
//                i_min = i - 1;
//                j_min = j;
//            } else if (fin_min == matrice[i + 1][j]) {
//                i_min = i + 1;
//                j_min = j;
//            } else if (fin_min == matrice[i][j - 1]) {
//                i_min = i;
//                j_min = j - 1;
//            } else {
//                i_min = i;
//                j_min = j + 1;
//            }
//        }
//        matrice[i_min][j_min] *= -1;
//        System.out.println("FROM MINN :: i = " + i_min + " j = " + j_min + " gives " + matrice[i_min][j_min]);
//    }

    private static int[] findMinVoisin(int[][] matrice, int i, int j) {
        int n = matrice.length;
        int i_min = 0, j_min = 0;
        if (i == 0 && j == 0) {
            // voisins.add(matrice[0][1]);
            // voisins.add(matrice[1][0]);
            if (Math.min(matrice[0][1], matrice[1][0]) == matrice[0][1]) {
                i_min = 0;
                j_min = 1;
            } else {
                i_min = 1;
                j_min = 0;
            }
        } else if (i == 0 && j == n - 1) {
            // voisins.add(matrice[0][n - 2]);
            // voisins.add(matrice[1][n - 1]);
            if (Math.min(matrice[0][n - 2], matrice[1][n - 1]) == matrice[0][n - 2]) {
                i_min = 0;
                j_min = n - 2;
            } else {
                i_min = 1;
                j_min = n - 1;
            }
        } else if (i == n - 1 && j == 0) {
            // voisins.add(matrice[n - 2][0]);
            // voisins.add(matrice[n - 1][1]);
            if (Math.min(matrice[n - 2][0], matrice[n - 1][1]) == matrice[n - 2][0]) {
                i_min = n - 2;
                j_min = 0;
            } else {
                i_min = n - 1;
                j_min = 1;
            }
        } else if (i == n - 1 && j == n - 1) {
            // voisins.add(matrice[n - 1][n - 2]);
            // voisins.add(matrice[n - 2][n - 1]);
            if (Math.min(matrice[n - 1][n - 2], matrice[n - 2][n - 1]) == matrice[n - 1][n - 2]) {
                i_min = n - 1;
                j_min = n - 2;
            } else {
                i_min = n - 2;
                j_min = n - 1;
            }
        } else if (i == 0) {
            // voisins.add(matrice[i][j - 1]);
            // voisins.add(matrice[i][j + 1]);
            // voisins.add(matrice[i + 1][j]);
            int temp_min = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
            if (temp_min <= matrice[i + 1][j]) {
                if (temp_min == matrice[i][j - 1]) {
                    i_min = i;
                    j_min = j - 1;
                } else {
                    i_min = i;
                    j_min = j + 1;
                }
            } else {
                i_min = i + 1;
                j_min = j;
            }
        } else if (i == n - 1) {
            // voisins.add(matrice[i][j - 1]);
            // voisins.add(matrice[i][j + 1]);
            // voisins.add(matrice[i - 1][j]);
            int temp_min = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
            if (temp_min <= matrice[i - 1][j]) {
                if (temp_min == matrice[i][j - 1]) {
                    i_min = i;
                    j_min = j - 1;
                } else {
                    i_min = i;
                    j_min = j + 1;
                }
            } else {
                i_min = i - 1;
                j_min = j;
            }
        } else if (j == 0) {
            // voisins.add(matrice[i - 1][j]);
            // voisins.add(matrice[i + 1][j]);
            // voisins.add(matrice[i][j + 1]);
            int temp_min = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
            if (temp_min <= matrice[i][j + 1]) {
                if (temp_min == matrice[i - 1][j]) {
                    i_min = i - 1;
                    j_min = j;
                } else {
                    i_min = i + 1;
                    j_min = j;
                }
            } else {
                i_min = i;
                j_min = j + 1;
            }
        } else if (j == n - 1) {
            // voisins.add(matrice[i - 1][j]);
            // voisins.add(matrice[i + 1][j]);
            // voisins.add(matrice[i][j - 1]);
            int temp_min = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
            if (temp_min <= matrice[i][j - 1]) {
                if (temp_min == matrice[i - 1][j]) {
                    i_min = i - 1;
                    j_min = j;
                } else {
                    i_min = i + 1;
                    j_min = j;
                }
            } else {
                i_min = i;
                j_min = j - 1;
            }
        } else {
            // voisins.add(matrice[i - 1][j]);
            // voisins.add(matrice[i + 1][j]);
            // voisins.add(matrice[i][j - 1]);
            // voisins.add(matrice[i][j + 1]);
            int min_1 = Math.min(matrice[i - 1][j], matrice[i + 1][j]);
            int min_2 = Math.min(matrice[i][j - 1], matrice[i][j + 1]);
            int fin_min = Math.min(min_1, min_2);
            if (fin_min == matrice[i - 1][j]) {
                i_min = i - 1;
                j_min = j;
            } else if (fin_min == matrice[i + 1][j]) {
                i_min = i + 1;
                j_min = j;
            } else if (fin_min == matrice[i][j - 1]) {
                i_min = i;
                j_min = j - 1;
            } else {
                i_min = i;
                j_min = j + 1;
            }
        }
        int[] min_coordinates = new int[2];
        min_coordinates[0] = i_min;
        min_coordinates[1] = j_min;
        return min_coordinates;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().replaceAll("\\s+$", "").
                    split(" ");
            for (int j = 0; j < inputs.length; ++j) {
                matrix[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        System.out.println(maxMatrixSum(matrix));
    }
}
