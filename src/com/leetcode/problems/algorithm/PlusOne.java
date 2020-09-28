package com.leetcode.problems.algorithm;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int overFlow = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + overFlow > 9) {
                digits[i] = 0;
                overFlow = 1;
            } else {
                digits[i] = digits[i] + 1;
                overFlow = 0;
                break;
            }
        }
        if (overFlow == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
