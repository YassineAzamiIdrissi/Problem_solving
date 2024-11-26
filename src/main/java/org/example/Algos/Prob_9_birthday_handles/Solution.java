package org.example.Algos.Prob_9_birthday_handles;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static int birthdayCakeCandles(List<Integer> candles) {
        int maximum = 0, count = 0;
        for (int i = 0; i < candles.size(); i++) {
            if (candles.get(i) >= candles.get(maximum)) {
                maximum = i;
            }
        }
        for (int element : candles) {
            if (element == candles.get(maximum)) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
