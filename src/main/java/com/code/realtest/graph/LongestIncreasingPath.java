package com.code.realtest.graph;

/**
 * @author maple
 * @Description 329. 矩阵中的最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * @createTime:2026-02-06 20:24
 */
public class LongestIncreasingPath {
    static int maxLength = 0;
    int rows = 0;
    int cols = 0;

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        longestIncreasingPath.longestIncreasingPath(matrix);

        System.out.println(maxLength);
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        rows = matrix.length;
        cols = matrix[0].length;
        int[][] memo = new int[rows][cols]; // 用于记忆化，memo[i][j] 表示从 (i,j) 出发的最长递增路径长度

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dfs(matrix,i,j,memo);
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix,int row,int col,int[][] memo){
        // 已计算过，直接返回记忆化的结果
        if(memo[row][col] != 0){
            return memo[row][col];
        }

        // 当前位置最短路径长度为 1（只有自己）
        int res = 1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int[] dir : dirs){
            int ni = row + dir[0];
            int nj = col + dir[1];

            if(ni >= 0 && ni < rows && nj >= 0 && nj < cols && matrix[ni][nj] > matrix[row][col]){
                res = Math.max(res,1 + dfs(matrix,ni,nj,memo));
            }
        }

        memo[row][col] = res; // 记忆化
        maxLength = Math.max(maxLength,res); // 更新全局最长路径

        return res;
    }
}
