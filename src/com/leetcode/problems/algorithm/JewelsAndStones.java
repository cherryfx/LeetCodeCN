package com.leetcode.problems.algorithm;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        if(J == null || S == null) {
            return count;
        }
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        Set<Character> kindOfJewels = new HashSet<>();
        for (char j : js) {
            kindOfJewels.add(j);
        }
        for (char s : ss) {
            if(kindOfJewels.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
