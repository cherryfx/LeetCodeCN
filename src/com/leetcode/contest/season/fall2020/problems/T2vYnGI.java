package com.leetcode.contest.season.fall2020.problems;

public class T2vYnGI {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int count = 0;
        for (int i = 0; i < staple.length; i++) {
            int sub = x - staple[i];
            if (sub <= 0) {
                continue;
            }
            for (int j = 0; j < drinks.length; j++) {
                if (sub >= drinks[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
