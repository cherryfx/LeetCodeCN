package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    Deque<Integer> inner = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, int sum, int currentIndex) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(inner));
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            inner.addLast(candidate);
            dfs(candidates, target, candidate + sum, i);
            inner.removeLast();
        }
    }

}
