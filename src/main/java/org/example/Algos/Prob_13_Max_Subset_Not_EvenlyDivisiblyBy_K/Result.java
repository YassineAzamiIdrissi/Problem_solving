package org.example.Algos.Prob_13_Max_Subset_Not_EvenlyDivisiblyBy_K;

import java.util.List;

public class Result {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] restsCount = new int[k];
        for (Integer num : s) {
            restsCount[num % k]++;
        }
        int searchedMaxSetCard = 0;
        if (restsCount[0] > 0) {
            searchedMaxSetCard++;
        }

        for (int r = 1; r <= (k / 2); ++r) {
            if (r == k - r) {
                searchedMaxSetCard++;
            } else {
                searchedMaxSetCard+=Math.max(restsCount[r], restsCount[k-r]);
            }
        }
        return searchedMaxSetCard;
    }
    // Notes :
    // The idea of this problem is very different :
    // we will count the occurrences of the rest of all the  (working in Z/kZ)

}
