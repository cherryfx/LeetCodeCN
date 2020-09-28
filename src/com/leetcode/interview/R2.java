//package com.leetcode.interview;
//
//import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class R2 {
//
//    public static void main(String[] args) {
//        int[][] matrix = {{0,0,0}, {0,1,0}, {1,1,1}};
//
//        R2 r = new R2();
//
//        r.updateMatrix(matrix);
//
//
//    }
//
//    public int[][] updateMatrix(int[][] matrix) {
//        int[][] result = new int[matrix.length][matrix[0].length];
//        // 存储所有零点坐标
//        List<Integer> xyPoint = new ArrayList<>(); // 存储XY 坐标
//        for(int i=0 ; i< matrix.length; i++) {
//            for(int j=0; j< matrix[0].length; j++) {
//                if(matrix[i][j]==0) {
//                    xyPoint.add(i);
//                    xyPoint.add(j);
//                }
//            }
//        }
//
//        for(int i=0 ; i< matrix.length; i++) {
//            for(int j=0; j< matrix[0].length; j++) {
//                if(matrix[i][j]==0) {
//                    result[i][j] = 0;
//                } else {
//                    result[i][j] = Integer.MAX_VALUE;
//                    for(int z=0; z<xyPoint.size(); ) {
//                        int zX = xyPoint.get(z++);
//                        int zY = xyPoint.get(z++);
//                        int distance = Math.abs(zX - i) + Math.abs(zY - j);
//                        result[i][j] = Math.min(result[i][j], distance);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}
