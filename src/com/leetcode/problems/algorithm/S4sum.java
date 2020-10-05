package com.leetcode.problems.algorithm;

import java.util.*;

public class S4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                for (int m = j + 1; m < nums.length - 1; m++) {
                    if (m > j + 1 && nums[m - 1] == nums[m]) {
                        continue;
                    }
                    for (int n = m + 1; n < nums.length; n++) {
                        if (n > m + 1 && nums[n - 1] == nums[n]) {
                            continue;
                        }
                        if (target == nums[i] + nums[j] + nums[m] + nums[n]) {
                            result.add(new ArrayList<>(Arrays.asList(new Integer[]{nums[i], nums[j], nums[m], nums[n]})));
                        }
                    }
                }
            }
        }
        return result;
    }
}
