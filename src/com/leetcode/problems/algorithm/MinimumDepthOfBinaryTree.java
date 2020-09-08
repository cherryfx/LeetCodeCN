package com.leetcode.problems.algorithm;

import com.leetcode.problems.algorithm.TreeNode;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

        MinimumDepthOfBinaryTree mdbt = new MinimumDepthOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        int i = mdbt.minDepth(root);

        System.out.println(i);


    }


    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null) {
            return depth;
        }
        int i = firstVisit(root, depth);
        return i;
    }

    public int firstVisit(TreeNode root, int depth) {
        depth++;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null) {
            left = firstVisit(root.left, depth);
        }
        if(root.right != null) {
            right = firstVisit(root.right, depth);
        }
        if(root.left == null && root.right == null) {
            return depth;
        }
        if(left > right) {
            return right;
        } else {
            return left;
        }
    }
}
