package com.leetcode.problems.algorithm;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        // 转化
        char[][] chars = new char[strs.length][];
        // 记录最短列记录
        int length = 65535;
        for(int i=0; i<strs.length; i++) {
            chars[i] = strs[i].toCharArray();
            if(length > chars[i].length) {
                length = chars[i].length;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            boolean flag =true;
            for(int j=0; j<chars.length; j++) {
                if(chars[0][i]!=chars[j][i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(chars[0][i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
