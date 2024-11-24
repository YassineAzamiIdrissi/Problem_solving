package org.example.Java.Prob_1_Deques;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> uniqueElements = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUniqueCount = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            uniqueElements.add(num);
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                if (!deque.contains(removed)) {
                    uniqueElements.remove(removed);
                }
            }
            maxUniqueCount = Math.max(maxUniqueCount, uniqueElements.size());
        }
        System.out.println(maxUniqueCount);
        in.close();
    }
}
