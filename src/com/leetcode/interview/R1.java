package com.leetcode.interview;

import java.util.*;

public class R1 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Set<String>[] companies = new Set[n];
        for (int i = 0; i < n; i++) {
            companies[i] = new HashSet(favoriteCompanies.get(i));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;// 跳过自身
                }
                if (companies[j].containsAll(companies[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}
