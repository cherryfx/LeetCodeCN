package com.leetcode.problems.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SegmentTree<E> {

    SegmentTree() {
        E[] arr = (E[]) new Object[32];

        Map<Integer, Integer> existsMap = new HashMap<>();

        Integer orDefault = existsMap.getOrDefault(1, 2);

        StringBuilder sb = new StringBuilder();

        sb.append(3 - 2).append('A');

    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();

        for (int i = 1; i < 9; i++) {
            String s = st.countAndSay(i);
            System.out.println(s);
        }


    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for (int i = 2; i <= n; i++) {
            char[] charry = sb.toString().toCharArray();
            sb = new StringBuilder();
            int current = 0;
            for (int j = 0; j < charry.length - 1; j++) {
                if (charry[j] == charry[j + 1]) {
                    continue;
                }
                sb.append(j - current + 1).append(charry[j]);
                current = j + 1;
            }
            sb.append(charry.length - current).append(charry[charry.length - 1]);
        }
        return sb.toString();
    }

}
