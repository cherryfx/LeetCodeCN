package com.leetcode.problems.algorithm;

public class BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        BiaoShiShuZhiDeZiFuChuanLcof lcof = new BiaoShiShuZhiDeZiFuChuanLcof();

        String s = "1 ";

        s = ".1";


        boolean number = lcof.isNumber(s);

        System.out.println(number);
    }

    public boolean isNumber(String s) {
        char[] chars = s.trim().toLowerCase().toCharArray();
        if (chars.length == 0) {
            return false;
        }
        if (chars.length == 1) {
            if (chars[0] > '9' || chars[0] < '0') {
                return false;
            }
        }
        int eIdx = -1, pIdx = -1, opIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                return false;
            }
            if (i == 0) {
                if (c != '.' && c != '+' && c != '-' && (c > '9' || c < '0')) {
                    return false;
                }
                if (c == '.') {
                    pIdx = i;
                }

            } else if (i == chars.length - 1) {
                if (c != '.' && (c > '9' || c < '0')) {
                    return false;
                }
                if (c == '.') {
                    if (pIdx > -1 || eIdx > -1 || chars[i - 1] == '+' || chars[i - 1] == '-') {
                        return false;
                    }
                }
            } else {
                if (c != 'e' && c != '.' && c != '+' && c != '-' && (c > '9' || c < '0')) {
                    return false;
                }
                if (c == 'e') {
                    if (chars[i - 1] == '+' || chars[i - 1] == '-') {
                        return false;
                    }
                    if (eIdx > -1) {
                        return false;
                    }
                    if (i - 1 == pIdx) {
                        return false;
                    }
                    eIdx = i;
                }
                if (c == '.') {
                    if (pIdx > -1 || eIdx > -1) {
                        return false;
                    }
                    pIdx = i;
                }
                if (c == '+' || c == '-') {
                    if (eIdx == -1) {
                        return false;
                    }
                    if (eIdx + 1 != i) {
                        return false;
                    }
                    if (opIdx > -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
