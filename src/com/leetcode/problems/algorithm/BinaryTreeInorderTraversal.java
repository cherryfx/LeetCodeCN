package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> integers = btit.inorderTraversal(root);

        System.out.println(integers);


    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addFirst(root);
        }
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();// 获取当前节点
            if (peek.left != null) {
                stack.addFirst(peek.left);
                peek.left = null;
                continue;
            }
            TreeNode treeNode = stack.pollFirst();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.addFirst(treeNode.right);
            }
        }
        return result;
    }
}
