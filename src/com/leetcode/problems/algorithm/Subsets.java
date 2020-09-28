package com.leetcode.problems.algorithm;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();

        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});

        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null) {
            return result;
        }
        Deque<Integer> inner = new ArrayDeque<>();
        dfs(nums, 0, result, inner);
        return result;
    }

    public void dfs(int[] nums, int currentIndex, List<List<Integer>> result, Deque<Integer> inner) {
        if (currentIndex == nums.length) {
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            inner.addLast(nums[i]);
            result.add(new ArrayList<>(inner));
            dfs(nums, i + 1, result, inner);
            inner.removeLast();
        }
    }
}
