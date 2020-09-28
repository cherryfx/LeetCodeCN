package com.leetcode.problems.algorithm;

public class ConvertBstToGreaterTree {

    public static void main(String[] args) {
        ConvertBstToGreaterTree cbtgt = new ConvertBstToGreaterTree();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(13);
//        TreeNode treeNode = cbtgt.convertBST(root);

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        TreeNode treeNode = cbtgt.convertBST(root);
        System.out.println(treeNode);
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
    }
}
