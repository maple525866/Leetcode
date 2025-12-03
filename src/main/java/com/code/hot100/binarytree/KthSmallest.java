package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 230. 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * @createTime:2025-12-03 17:14
 */
public class KthSmallest {
    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        Integer[] arr = {3,1,4,null,2};
        TreeNode root = kthSmallest.buildTree(arr);
        System.out.println(kthSmallest.kthSmallest(root, 1));
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

    private int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root != null) stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if(node != null){
                stack.pop();

                if(node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if(node.left != null) stack.push(node.left);
            }else{
                stack.pop();
                res.add(stack.pop().val);
            }
        }

        return res.get(k-1);
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
