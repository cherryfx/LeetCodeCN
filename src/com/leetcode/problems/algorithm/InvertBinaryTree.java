package com.leetcode.problems.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);// 放入队尾
        while (!queue.isEmpty()) {//如果队列不为空，则继续循环
            TreeNode pop = queue.pop();//从队列头部取出元素
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            if (right != null) {
                queue.offer(right);//优先放入右队列，达到交换的目的
            }
            if (left != null) {
                queue.offer(left);
            }
            //交换当前元素的左右子节点
            pop.left = right;
            pop.right = left;

        }
        return root;
    }


}
