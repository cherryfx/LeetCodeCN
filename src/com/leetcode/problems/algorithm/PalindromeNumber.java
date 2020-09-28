package com.leetcode.problems.algorithm;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || x > 0 && x % 10 == 0) {
            return false;
        }
        int y = 0;
        while (x / 10 > y) {
            int temp = x % 10;
            y = y * 10 + temp;
            x = x / 10;
        }
        if (x == y) {
            return true;
        } else {
            return x / 10 == y;
        }
    }
}
