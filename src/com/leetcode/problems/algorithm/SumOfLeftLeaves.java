package com.leetcode.problems.algorithm;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dfs = dfs(root, 0);
        return dfs;
    }

    /**
     * @param root
     * @param direction 0-根节点 1-左子树 2-右子树
     * @return
     */
    public int dfs(TreeNode root, int direction) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            if (direction == 1) {
                return sum + root.val;
            }
            return sum;
        }
        if (root.left != null) {
            sum = sum + dfs(root.left, 1);
        }
        if (root.right != null) {
            sum = sum + dfs(root.right, 2);
        }
        return sum;
    }
}
