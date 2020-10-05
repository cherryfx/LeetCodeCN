package com.leetcode.problems.algorithm;

public class UlBDOe {

    public static void main(String[] args) {
        UlBDOe ulBDOe = new UlBDOe();

        int count = ulBDOe.minimumOperations("rrryyyrryyyrr");

        System.out.println(count);

    }


    public int minimumOperations(String leaves) {
        if(leaves==null || "".equals(leaves.trim())) {
            return 0;
        }
        char[] chars = leaves.toUpperCase().toCharArray();
        int[][] leaveStates = new int[chars.length][3];
        //设置二维数组的第二维度为树叶的状态，可选值为 第一次红色0， 第二次红色2， 黄色1
        //二维数组的第一维度为记录下，如要达到当前状态，需要对叶子进行调整的次数
        /**
         * 为符合题目要求（RYR）初步分析可得
         * 对于第一片叶子，只能是 黄色，若为否，则需要调整一次为黄色，其余两种状态为非法状态
         * 对于第二片叶子，则可以选择0-黄色，1-红色，而2-黄色依然为非法状态
         *
         * 注意三目运算符优先级问题，否则将导致报错
         *
         *
         */
        leaveStates[0][0] = chars[0] == 'Y' ? 1 : 0; // 若第一片叶子为黄色，则进行1次替换
        leaveStates[0][1] = Integer.MAX_VALUE; // 不可达，即不存在此种替换
        leaveStates[0][2] = Integer.MAX_VALUE; // 不可达，即不存在此种替换
        for(int i=1; i<chars.length; i++) {
            char currentCharacter = chars[i];//当前节点颜色
            // 对于状态0 若当前节点为0-黄色，则其前驱节点依然为 黄色 才能符合RYR要求
            leaveStates[i][0] = leaveStates[i-1][0] + (currentCharacter == 'Y' ? 1 : 0);
            // 对于状态1 若当前节点为1-红色，则其前驱节点可以为0-黄色，1-红色 均可，从中挑选最小的一个进行组合即可
            leaveStates[i][1] = Math.min(leaveStates[i-1][0], leaveStates[i-1][1]) + (currentCharacter == 'R' ? 1:0);
            // 对于状态2 若当前节点为2-黄色，则其前驱节点可以为2-黄色，1-红色 均可，从中挑选最小的一个进行组合即可
            if(i >= 2) {
                leaveStates[i][2] = Math.min(leaveStates[i-1][1], leaveStates[i-1][2]) + (currentCharacter == 'Y' ? 1:0);
            } else {
                // 2-黄色 为非法状态
                leaveStates[i][2] = Integer.MAX_VALUE;
            }
        }

        return leaveStates[chars.length-1][2];
    }
}
