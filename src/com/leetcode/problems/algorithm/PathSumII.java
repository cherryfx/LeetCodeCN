package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> inner = new ArrayDeque<>();
        dfs(root, sum, result, inner);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> inner) {
        if (root == null) {
            return;
        }

        inner.addLast(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(inner));
        }

        dfs(root.left, sum - root.val, result, inner);
        dfs(root.right, sum - root.val, result, inner);
        inner.removeLast();
    }
}
