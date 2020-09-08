package com.leetcode.problems.algorithm;

public class ShortestPalindrome {

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();

        String s = "aacecaaa";

        s = "abcd";

        s = "cbabcd";


        String s1 = sp.shortestPalindrome(s);

        System.out.println(s1);


    }


    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String s1 = sb.append(s).reverse().toString();

        if(s.equals(s1)) {
            return s;
        }

        int padding = 0;
        while(true) {
            if(!s.substring(0, s.length() -padding).equals(s1.substring(padding))) {
                padding++;
            } else {
                break;
            }
        }

        sb = new StringBuilder();
        return sb.append(s.substring(s.length() - padding)).reverse().append(s).toString();


    }
}
