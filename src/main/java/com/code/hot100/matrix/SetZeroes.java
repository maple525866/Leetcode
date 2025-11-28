package com.code.hot100.matrix;

import java.util.Arrays;

/**
 * @author maple
 * @Description 73.矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 * [1,1,1],[1,0,1],[1,1,1]
 * @createTime:2025-11-28 18:12
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(Arrays.deepToString(matrix));

        System.out.println(Arrays.deepToString(new SetZeroes().setZeroes(matrix)));

        System.out.println(Arrays.deepToString(matrix));
    }

    public int[][] setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
