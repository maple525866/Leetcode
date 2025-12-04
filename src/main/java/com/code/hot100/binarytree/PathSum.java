package com.code.hot100.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 437. 路径总和 III
 *给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条
 * @createTime:2025-12-03 21:51
 */
public class PathSum {
    public static void main(String[] args) {
        Integer[] arr = {10,5,-3,3,2,null,11,3,-2,null,1};
        PathSum pathSum = new PathSum();
        TreeNode root = pathSum.buildTree(arr);
        System.out.println(pathSum.pathSum(root, 8));
    }
    private TreeNode buildTree(Integer[] nums){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() && i < nums.length){
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

    private int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int ret = rootSum(root,sum);

        // 左右子节点也可以从sum开始判断
        ret += pathSum(root.left,sum);
        ret += pathSum(root.right,sum);

        return ret;
    }

    private int rootSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        if(root.val == sum){
            ret++;
        }
        // 当前节点当作父节点，向下面找
        ret += rootSum(root.left,sum - root.val);
        ret += rootSum(root.right,sum - root.val);

        return ret;
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
