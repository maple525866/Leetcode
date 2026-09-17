package com.code.realtest.binarytree;

/**
 * @author maple
 * @Description 所有路径之和 招银网络一面
 * 题目理解
 * 题目要求计算从根节点到叶子节点的所有路径所表示的数字之和。
 * 每条路径从根节点到叶子节点，将路径上的节点值按顺序拼接成一个数字。
 * 例如：路径 [1, 2, 3] 表示数字 123，路径 [1, 3] 表示数字 13。
 * 最终返回所有路径数字的总和
 * @createTime:2026-09-17 20:44
 */
public class PathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int currentSum) {
        return dfs(root, currentSum);
    }

    private int dfs(TreeNode node, int currentSum) {
        // 如果节点为空，返回 0
        if (node == null) {
            return 0;
        }

        // 更新当前路径数字
        currentSum = currentSum * 10 + node.val;

        // 如果是叶子节点，返回当前数字
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // 否则，继续递归左右子树，并将结果相加
        return pathSum(node.left, currentSum) + pathSum(node.right, currentSum);
    }
}
