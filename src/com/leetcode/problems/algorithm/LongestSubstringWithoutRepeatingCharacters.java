package com.leetcode.problems.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";
//        s = "ab";
//        s = "aab";
        s = "tmmzuxt";
        int i = lswrc.lengthOfLongestSubstring(s);

        System.out.println(i);
    }


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        int maxLenght = 0, start = 0;
        for(int index=0; index<chars.length; index++) {
            Integer integer = maps.get(chars[index]);
            if(integer < start) {
                continue;
            }
            if(index == chars.length - 1) {
                if(integer == null) {
                    if(maxLenght < index - start + 1) {
                        maxLenght = index - start + 1;
                    }
                }
            }
            maps.put(chars[index], index);
            if(integer != null) {

                if(maxLenght < index - start) {
                    maxLenght = index - start;
                }
                start = integer + 1;
            }
        }

        return maxLenght;
    }
}
