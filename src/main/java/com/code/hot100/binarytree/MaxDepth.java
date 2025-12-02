package com.code.hot100.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 104.二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 *
 * 输入：root = [1,null,2]
 * 输出：2
 * @createTime:2025-12-02 15:19
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = new MaxDepth().maxDepth(root);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;

        if(root != null) queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
