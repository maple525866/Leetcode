package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * @createTime:2025-12-02 16:45
 */
public class InvertTree {
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};
        InvertTree invertTree = new InvertTree();
        TreeNode root = invertTree.buildTree(arr);
        System.out.println(invertTree.printTree(root).toString());
        root = invertTree.invertTree(root);
        System.out.println(invertTree.printTree(root).toString());
    }

    /**
     * 按照层序遍历来构造一个二叉树
     * @param nums 提供的int[]数组
     * @return 二叉树父节点
     */
    public TreeNode buildTree(Integer[] nums){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < nums.length){
            TreeNode node = queue.poll();

            // 左孩子
            if (i < nums.length) {
                if (nums[i] != null) {
                    node.left = new TreeNode(nums[i]);
                    queue.offer(node.left);
                }
                // 如果是 null，node.left 默认就是 null，无需赋值
                i++;
            }

            // 右孩子
            if (i < nums.length) {
                if (nums[i] != null) {
                    node.right = new TreeNode(nums[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    public List<Integer> printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        exchange(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private void exchange(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
