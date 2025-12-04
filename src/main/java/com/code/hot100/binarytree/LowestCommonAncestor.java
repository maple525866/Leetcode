package com.code.hot100.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * @createTime:2025-12-04 13:57
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        Integer[] arr = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = lowestCommonAncestor.buildTree(arr);

    }

    private TreeNode buildTree(Integer[] nums){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() || i < nums.length){
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

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = helper(root,p,q);
        return node;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if(left == null && right == null){
            return null;
        }else if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else {
            return root;
        }
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
