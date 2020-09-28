package com.leetcode.problems.algorithm;

import java.util.*;

/**
 * 40. 组合总和 II
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 优先对数组排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> inner = new ArrayDeque<>();
        dfs(candidates, target, 0, 0, inner, result);
        return result;
    }

    public void dfs(int[] candidates, int target, int current, int sum, Deque<Integer> inner, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = current; i < candidates.length; i++) {
            inner.addLast(candidates[i]);
            dfs(candidates, target, i + 1, candidates[i] + sum, inner, result);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++; //同一层for循环中，跳过所有重复项
            }
            inner.removeLast();
        }
    }
}
