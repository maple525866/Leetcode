package com.code.hot100.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * @createTime:2025-12-04 14:37
 */
public class MaxPathSum {
    int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Integer[] arr = {-10,9,20,null,null,15,7};
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = maxPathSum.buildTree(arr);
        System.out.println(maxPathSum.maxPathSum(root));
    }

    private TreeNode buildTree(Integer[] nums) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode node = queue.poll();

            if(i < nums.length){
                if(nums[i] != null){
                    node.left = new TreeNode(nums[i]);
                    queue.offer(node.left);
                }
                i++;
            }

            if(i < nums.length){
                if(nums[i] != null){
                    node.right = new TreeNode(nums[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    private int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int store = 0;
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);

        // 如果左右分支有小于0的，说明它不能为最大路径和出力,因此排除掉,这里有贪心的思想
        if(leftMax == 0) leftMax = 0;
        if(rightMax == 0) rightMax = 0;

        store = leftMax + rightMax + root.val;
        res = Math.max(res, store);

        return Math.max(leftMax, rightMax) + root.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
