package org.example.ProbIlyas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static String wordFromSet(Set<Character> set) {
        StringBuilder ret = new StringBuilder();
        for (Character c : set) {
            ret.append(c);
        }
        return ret.toString();
    }

    public static boolean rightMotif(String word, String motif) {
        if (word.length() % motif.length() != 0) return false;
        int wordsize = word.length();
        int motifsize = motif.length();
        // int num = wordsize / motifsize; // ensemble N
        ArrayList<String> witness = new ArrayList<>();
        for (int i = 0; i < wordsize; i += motifsize) {
            String mot = word.substring(i, i + motifsize);
            witness.add(mot);
        }
        String firstWord = witness.getFirst();
        boolean isit = true;
        for (int i = 1; i < witness.size(); i++) {
            if (!witness.get(i).equals(firstWord)) {
                isit = false;
                break;
            }
        }
        return isit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<Character> motif = new HashSet<>();
        String mtf = "";
        ArrayList<String> possibles = new ArrayList<>();
//        for (int i = 0; i < input.length(); i++) {
//            if (!motif.contains(input.charAt(i))) {
//                motif.add(input.charAt(i));
//            } else {
//                mtf = wordFromSet(motif);
//                break;
//            }
//        }
        for (int i = 0; i < (input.length()) / 2; ++i) {
            String word = input.substring(0, i + 1);
            possibles.add(word);
        }
        for (int i = 0; i < possibles.size(); i++) {
            if (rightMotif(input, possibles.get(i))) {
                System.out.println(possibles.get(i));
                break;
            }
        }
    }
}
