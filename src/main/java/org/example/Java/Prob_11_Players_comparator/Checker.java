package org.example.Java.Prob_11_Players_comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int score_comparing = Integer.compare(p2.score, p1.score);
        if (score_comparing != 0) return score_comparing;
        else {
            return p1.name.compareTo(p2.name);
        }
    }
}
