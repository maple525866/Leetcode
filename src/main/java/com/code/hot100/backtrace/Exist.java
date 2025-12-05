package com.code.hot100.backtrace;

/**
 * @author maple
 * @Description 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 *
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCCED"
 * 输出：true
 * @createTime:2025-12-05 20:11
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        Exist exist = new Exist();
        boolean res = exist.exist(board, "ABCCED");

        System.out.println(res);
    }

    public boolean exist(char[][] board, String word){
        char[] ch = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board,ch,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] ch, int i, int j, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != ch[k]) return false;

        if(k == ch.length - 1) return true;

        board[i][j] = '\0';

        boolean res = dfs(board,ch,i + 1,j,k+1) || dfs(board,ch,i - 1,j,k+1) ||
                dfs(board,ch,i,j + 1,k+1) || dfs(board,ch,i,j - 1,k+1);

        board[i][j] = ch[k];

        return res;
    }
}
