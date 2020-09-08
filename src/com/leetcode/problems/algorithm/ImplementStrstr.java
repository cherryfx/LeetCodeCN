package com.leetcode.problems.algorithm;

public class ImplementStrstr {

    public static void main(String[] args) {
        ImplementStrstr is = new ImplementStrstr();

        String haystack = "hello";
        String needle = "ll";

        int i = is.strStr(haystack, needle);

        System.out.println(i);


    }
    /**
     * 利用BM算法求解
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle==null || "".equals(needle)) {
            return 0;
        }
        // 坏字符、 好后缀

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int shift = 0;// 偏移量
        int badIndex=0;//坏字符
        int goodSuffix=0;//好后缀


        for(int i=0; i< haystackArray.length; i++) {
            int badShift = -1, goodShift = -1;
            goodSuffix = 0;
            for(int j= needleArray.length -1; j>=0; j--) {
                if(j + shift + 1 > haystackArray.length) {
                    break;
                }
                if(needleArray[j] != haystackArray[i+shift]) {
                    badIndex = j;//得到坏字符的位置
                    break;
                } else {
                    goodSuffix++;
                }
            }
            if(goodSuffix== needleArray.length) {
                break;
            }
            /* 开始计算偏移量 */
            //1. 计算坏字符的偏移量
            for(int s=badIndex-1; s>=0; s--) {
                if(needleArray[s] == needleArray[badIndex]) {
                    badShift = badIndex - s + 1;
                }
            }
            //2. 计算好后缀的偏移量
            for(int s=goodShift-1; s>=0; s--) {
                if(needleArray[s] == needleArray[needleArray.length-1]) {
                    goodShift = needleArray.length - s;
                }
            }
            shift = Math.max(badIndex, goodShift);
        }

        /* 未找到则返回-1 */
        if(goodSuffix < needleArray.length) {
            shift = -1;
        }

        return shift;
    }
}
