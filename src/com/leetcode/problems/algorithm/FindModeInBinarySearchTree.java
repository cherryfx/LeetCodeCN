package com.leetcode.problems.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    public static void main(String[] args) {
        FindModeInBinarySearchTree fibst = new FindModeInBinarySearchTree();

        int[] mode = fibst.findMode(new TreeNode(2147483647));

        System.out.println(mode);
    }


    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 众数个数大小
        int modeCount = 0;
        // 当前值个数大小
        int currentCount = 1;
        // 上次值
        int lastValue = Integer.MAX_VALUE;
        // 采用morris算法计算
        while (root != null) {
            if (root.left == null) {
                if (lastValue == root.val) {
                    currentCount++;
                    if (currentCount > modeCount) {
                        modeCount = currentCount;
                        result.clear();
                        result.add(root.val);
                    } else if (currentCount == modeCount) {
                        result.add(root.val);
                    }
                } else {
                    currentCount = 1;
                    if (currentCount > modeCount) {
                        modeCount = currentCount;
                        result.clear();
                        result.add(root.val);
                    } else if (currentCount == modeCount) {
                        result.add(root.val);
                    }
                    lastValue = root.val;
                }
                root = root.right;
                continue;
            }

            TreeNode preNode = root.left;
            while (preNode.right != null && preNode.right != root) {
                preNode = preNode.right;
            }

            if (preNode.right == null) {
                preNode.right = root;
                root = root.left;
            } else {
                if (lastValue == root.val) {
                    currentCount++;
                    if (currentCount > modeCount) {
                        modeCount = currentCount;
                        result.clear();
                        result.add(root.val);
                    } else if (currentCount == modeCount) {
                        result.add(root.val);
                    }
                } else {
                    currentCount = 1;
                    if (currentCount > modeCount) {
                        modeCount = currentCount;
                        result.clear();
                        result.add(root.val);
                    } else if (currentCount == modeCount) {
                        result.add(root.val);
                    }
                    lastValue = root.val;
                }

                preNode.right = null;
                root = root.right;
            }

        }


        int[] mode = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            mode[i] = result.get(i);
        }
        return mode;
    }
}
