package org.example.Algos.Prob_3_TripletComparison;


import java.util.ArrayList;
import java.util.List;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(aliceScore);
        scores.add(bobScore);
        return scores;
    }

}