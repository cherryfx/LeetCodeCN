package com.leetcode.problems.algorithm;

public class YuCeYingJia {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }


    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }

        int left = nums[start] * turn + total(nums, start + 1, end, -1);

        int right = nums[end] * turn + total(nums, start, end - 1, -1);

        return Math.max(left * turn, right * turn) * turn;


    }
}
