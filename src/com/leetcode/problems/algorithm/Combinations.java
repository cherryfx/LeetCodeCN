package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> inner = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }

    public void dfs(int current, int n, int k) {
//        if(n - current + 1 < k) {
//            return;
//        }
        if (inner.size() == k) {
            result.add(new ArrayList<>(inner));
            return;
        }

        for (int i = current; i <= n; i++) {
            inner.addLast(i);
            dfs(i + 1, n, k);
            inner.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();

        c.combine(4, 2);
    }

}
