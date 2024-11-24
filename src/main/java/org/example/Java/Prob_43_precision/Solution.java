package org.example.Java.Prob_43_precision;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        Map<String, Double> desc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            double num = Double.parseDouble(s[i]);
            desc.put(s[i], num);
        }
        sc.close();
        Set<String> keys = desc.keySet();
        ArrayList<Double> values = new ArrayList<>();
        for (String key : keys) {
            values.add(desc.get(key));
        }
        values.sort(Collections.reverseOrder());
        int index = 0;
        for (String key : keys) {
            if (Objects.equals(desc.get(key), values.get(index))) {
                System.out.println(key);
            }
            index++;
        }
    }

}
