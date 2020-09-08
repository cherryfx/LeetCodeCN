package com.leetcode.problems.algorithm;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] reverseAllString = sb.append(s).reverse().toString().split(" ");
        sb = new StringBuilder();
        for (int i = reverseAllString.length - 1; i>=0; i--) {
            sb.append(reverseAllString[i]);
            if(i>0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
