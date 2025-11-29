package com.code.hot100.matrix;

/**
 * @author maple
 * @Description 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * @createTime:2025-11-29 12:19
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 15;

        boolean flag = new SearchMatrix().searchMatrix(matrix, target);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            }else if (matrix[row][col] < target) {
                row++;
            }else {
                return true;
            }
        }

        return false;
    }
}
