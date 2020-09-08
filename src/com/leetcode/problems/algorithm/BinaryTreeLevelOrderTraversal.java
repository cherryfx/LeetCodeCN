package com.leetcode.problems.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> tempResult = new ArrayList<>();
        List<TreeNode> inner = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        inner.add(root);
        tempResult.add(inner);

        int level = 0;
        while (true) {
            List<TreeNode> current = tempResult.get(level);
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
                TreeNode treeNode = current.get(i);
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            if (next.size() > 0) {
                tempResult.add(next);
            } else {
                break;
            }
            level++;
        }

        for (int i = 0; i < tempResult.size(); i++) {
            List<TreeNode> treeNodes = tempResult.get(i);
            List<Integer> resultSub = new ArrayList<>();
            for (int j = 0; j < treeNodes.size(); j++) {
                resultSub.add(treeNodes.get(j).val);
            }
            result.add(resultSub);
        }

        return result;
    }

}

