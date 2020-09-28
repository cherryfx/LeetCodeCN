package com.leetcode.contest.season.fall2020.problems;

public class NGK0Fy {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case 'A':
                    x = 2 * x + y;
                    break;
                case 'B':
                    y = 2 * y + x;
                    break;
            }
        }
        return x + y;
    }
}
