package com.leetcode.problems;

/**
 * 通过BM 算法查询字符串
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if(needle==null || "".equals(needle)) {
            return 0;
        }

        if(needle.length() > haystack.length()) {
            return -1;
        }

        int shift = 0;

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();

        int bad = 0, good = 0;
        while(needles.length + shift <= haystacks.length) {
            for(int i=needles.length; i >=0; i--) {
                if(needles[i] == haystacks[shift + i]) {
                    good++;
                    if(i==0) {
                        return shift;
                    }
                } else {
                    bad = i;
                    int badshift = 0, goodshift = 0;
                    for(int j=needles.length -2; j>=0; j--) {

                    }
                }
            }

        }








        return -1;
    }
}
