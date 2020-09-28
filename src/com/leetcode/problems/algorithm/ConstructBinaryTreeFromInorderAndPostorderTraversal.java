package com.leetcode.problems.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 用于存储中序遍历的顺序
        Map<Integer, Integer> midNodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            midNodeIndex.put(inorder[i], i);
        }
        TreeNode root = null;
        TreeNode cur = null;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (root == null) {
                root = new TreeNode(postorder[i]);
                continue;
            }
            // 寻找前驱
            cur = root;
            int preValue = postorder[i];
            while (true) {
                if (midNodeIndex.get(cur.val) > midNodeIndex.get(preValue)) {
                    if (cur.left != null) {
                        cur = cur.left;
                        continue;
                    } else {
                        cur.left = new TreeNode(preValue);
                        break;
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right;
                        continue;
                    } else {
                        cur.right = new TreeNode(preValue);
                        break;
                    }
                }
            }
        }
        return root;
    }
}
