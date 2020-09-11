package com.leetcode.problems.algorithm;

/**
 * 53. 最大子序和问题
 */
public class MaximumSubarray {
    /**
     * DP 算法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
//        int[] maxSum = new int[nums.length];
//
//        maxSum[0] = nums[0];
//
//        int max = maxSum[0];
//        for(int i=1; i<nums.length; i++) {
//            if(maxSum[i-1] > 0) {
//                maxSum[i] = maxSum[i-1] + nums[i];
//            } else {
//                maxSum[i] = nums[i];
//            }
//            if(max < maxSum[i]) {
//                max = maxSum[i];
//            }
//        }
//        return max;

        int max = nums[0];
        int current = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(current > 0) {
                current = current + nums[i];
            } else {
                current = nums[i];
            }

            if(max < current) {
                max = current;
            }
        }
        return max;


    }
}
