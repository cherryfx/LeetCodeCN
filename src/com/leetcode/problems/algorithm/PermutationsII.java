package com.leetcode.problems.algorithm;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visits = new boolean[nums.length];
        Arrays.fill(visits, false);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> inner = new ArrayDeque<>();
        permutation(nums, visits, result, inner);
        return result;
    }

    public void permutation(int[] nums, boolean[] visits, List<List<Integer>> result, Deque<Integer> inner) {
        if (inner.size() == nums.length) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = 0; i < visits.length; i++) {
            if (visits[i] || (i + 1 < visits.length && nums[i] == nums[i + 1] && !visits[i + 1])) {
                continue;
            }
            inner.addLast(nums[i]);
            visits[i] = true;
            permutation(nums, visits, result, inner);
            visits[i] = false;
            inner.removeLast();
        }
    }
}
