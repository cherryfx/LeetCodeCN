package com.leetcode.problems.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {


        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        String content = "";
        firstV(root, content, list);
        return list;
    }

    public void firstV(TreeNode root, String content, List<String> list) {
        if ("".equals(content)) {
            content = "" + root.val;
        } else {
            content = content + "->" + root.val;
        }
        if (root.left != null) {
            firstV(root.left, content, list);
        }
        if (root.right != null) {
            firstV(root.right, content, list);
        }
        if (root.left == null && root.right == null) {
            list.add(content);
        }
    }


}
