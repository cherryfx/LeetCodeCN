package com.leetcode.interview;

public class R0 {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + nums[i];
        }
        currentSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum / k;
    }
}
