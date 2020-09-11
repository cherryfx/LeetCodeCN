package com.leetcode.problems.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();

        List<List<Integer>> lists = cs.combinationSum3(3, 7);


    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> inner = new ArrayDeque<>();
//        dfs(k, n, 0, 0, result, inner);
        dfs(k, n, 0, result, inner);
        return result;
    }

    public void dfs(int k, int n, int current, List<List<Integer>> result, Deque<Integer> inner) {
        int size = inner.size();
        if (size > k) {
            return;
        } else if (size < k && n == 0) {
            return;
        } else if (size == k && n != 0) {
            return;
        } else if (size == k && n== 0) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = current + 1; i <= 9; i++) {
            inner.addLast(i);
            dfs(k, n-i, i, result, inner);
            inner.removeLast();
        }
    }

//    public void dfs(int k, int n, int current, int sum, List<List<Integer>> result, Deque<Integer> inner) {
//        int size = inner.size();
//        if(size > k) {
//            return;
//        } else if(size < k && sum == n) {
//            return;
//        } else if(size == k && sum != n) {
//            return;
//        } else if(size == k && sum == n) {
//            result.add(new ArrayList<>(inner));
//            return;
//        }
//        for(int i=current+1; i<=9; i++) {
//            inner.addLast(i);
//            dfs(k, n, i, i+sum, result, inner);
//            inner.removeLast();
//        }
//    }
}
