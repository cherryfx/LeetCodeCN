package com.leetcode.problems.algorithm;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();

        int lastValue = 1000, sum = 0;

        for (char c : chars) {
            int v = 0;
            switch(c) {
                case 'I':
                    v = 1;
                    break;
                case 'V':
                    v = 5;
                    break;
                case 'X':
                    v = 10;
                    break;
                case 'L':
                    v = 50;
                    break;
                case 'C':
                    v = 100;
                    break;
                case 'D':
                    v = 500;
                    break;
                case 'M':
                    v = 1000;
                    break;
            }
            sum += v;
            if(v > lastValue) {
                sum -= 2 * lastValue;
            }
            lastValue = v;
        }

        return sum;


    }
}
