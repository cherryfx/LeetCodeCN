package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while (nodeDeque.size() != 0) {
            int size = nodeDeque.size();// 获取当前层节点的大小
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodeDeque.poll();
                sum = sum + poll.val;
                if (poll.left != null) {
                    nodeDeque.add(poll.left);
                }
                if (poll.right != null) {
                    nodeDeque.add(poll.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
