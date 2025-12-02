package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 101.对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * root = [1,2,2,3,4,4,3]
 * 输出：true
 * @createTime:2025-12-02 19:58
 */
public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        Integer[] arr = {1,2,2,3,4,4,3};
        TreeNode root = isSymmetric.buildTree(arr);
        System.out.println(isSymmetric.printBinaryTree(root));
        System.out.println(isSymmetric.isSymmetric(root));
    }
    private String printBinaryTree(TreeNode root) {
        if (root == null) return "";
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res.toString();
    }

    private TreeNode buildTree(Integer[] arr) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            if(i < arr.length) {
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    queue.addLast(node.left);
                }
                i++;
            }

            if(i < arr.length) {
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    queue.addLast(node.right);
                }
                i++;
            }
        }
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
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
