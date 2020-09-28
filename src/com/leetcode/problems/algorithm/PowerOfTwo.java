package com.leetcode.problems.algorithm;

public class PowerOfTwo {
//    public boolean isPowerOfTwo(int n) {
//        int baseValue = 1;
//        while (baseValue <=n && baseValue > 0) {
//            if(baseValue == n) {
//                return true;
//            }
//            baseValue = baseValue << 1;
//        }
//        return false;
//    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
