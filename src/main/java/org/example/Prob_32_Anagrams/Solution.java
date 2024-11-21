package org.example.Prob_32_Anagrams;

import java.util.*;

public class Solution {
    static boolean isAnagram(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        Map<Character, Integer> w1_occs = new HashMap<>();
        Map<Character, Integer> w2_occs = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            if (w1_occs.containsKey(word1.charAt(i))) {
                continue;
            }
            int num = 1;
            for (int j = i + 1; j < word1.length(); j++) {
                if (word1.charAt(i) == word1.charAt(j)) {
                    num++;
                }
            }
            w1_occs.put(word1.charAt(i), num);
        }
        for (int i = 0; i < word2.length(); i++) {
            if (w2_occs.containsKey(word2.charAt(i))) {
                continue;
            }
            int num = 1;
            for (int j = i + 1; j < word2.length(); j++) {
                if (word2.charAt(i) == word2.charAt(j)) {
                    num++;
                }
            }
            w2_occs.put(word2.charAt(i), num);
        }

        if (w1_occs.size() != w2_occs.size()) return false;
        for (Map.Entry<Character, Integer> entry : w1_occs.entrySet()) {
            if (!Objects.equals(entry.getValue(), w2_occs.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
