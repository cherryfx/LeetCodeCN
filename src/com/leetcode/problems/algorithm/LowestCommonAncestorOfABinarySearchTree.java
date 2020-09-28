package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LowestCommonAncestorOfABinarySearchTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) {
            return q;
        }
        List<List<TreeNode>> result = new ArrayList<>();
        Deque<TreeNode> inner = new ArrayDeque<>();
        dfs(root, p, q, result, inner);
        List<TreeNode> other = result.get(0);
        List<TreeNode> another = result.get(1);
        int size = other.size();
        if(another.size() < size) {
            size = another.size();
        }
        for(int i=size - 1; i>=0; i--) {
            if(other.get(i) == another.get(i)) {
                return other.get(i);
            }
        }
        return null;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q, List<List<TreeNode>> result, Deque<TreeNode> inner) {
        if(root == null) {
            return ;
        }
        if(result.size() == 2) {
            return ;
        }
        inner.add(root);
        if(root == q || root == p) {
            result.add(new ArrayList<>(inner));
        }
        dfs(root.left, p, q, result, inner);
        dfs(root.right, p, q, result, inner);
        inner.removeLast();
    }

}
