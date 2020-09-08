package com.leetcode.problems.algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> xxx = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            Integer index = xxx.get(target - nums[i]);
            if(index != null) {
                return new int[]{index, i};
            } else {
                xxx.put(nums[i], i);
            }
        }
        return null;
    }
}
