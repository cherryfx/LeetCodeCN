package com.leetcode.problems.algorithm;

public class LengthOfLastWord {

    /**
     * "Hello World"
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();
        int length = 0;
        for(int i=chars.length-1; i>=0; i--) {
            if(chars[i]==' ') {
                break;
            }
            length ++;
        }
        return length;
    }


}
