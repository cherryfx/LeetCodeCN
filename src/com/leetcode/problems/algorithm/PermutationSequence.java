package com.leetcode.problems.algorithm;

/**
 * 60. 第k个排列
 */
public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();

        int n = 9;
        int k = 54494;

        String permutation = ps.getPermutation(n, k);

        System.out.println(permutation);


    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int temp = 1;
        int mul = 1;
        int[] marks = new int[n];
        while (k > 1) {
            if (k > temp) {
                mul++;
                temp = temp * mul;
            } else {

                for (int i = 1; n > mul + sb.length(); i++) {
                    if (marks[i - 1] == 0) {
                        marks[i - 1] = 1;// 标记已访问
                        sb.append(i);
                    }
                }

                int rem = (k - 1) / (temp / mul);
                k = k - rem * temp / mul;
                for (int i = 0; i < marks.length; i++) {
                    if (marks[i] == 0) {
                        rem--;
                    }
                    if (rem == -1) {
                        marks[i] = 1;
                        sb.append(i + 1);
                        mul = 1;
                        temp = 1;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == 0) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }


}
