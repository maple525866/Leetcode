package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 543. 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * @createTime:2025-12-02 20:29
 */
public class DiameterOfBinaryTree {
    int treeDepth = 0;

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = diameterOfBinaryTree.buildTree(arr);
        System.out.println(diameterOfBinaryTree.printBinaryTree(root));
        int i = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(i);
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
        queue.addLast(root);
        int i = 1;

        while(!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.removeFirst();

            if(i < arr.length) {
                if(arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.addLast(node.left);
                }
                i++;
            }

            if(i < arr.length) {
                if(arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.addLast(node.right);
                }
                i++;
            }
        }
        return root;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        treeDiameter(root);
        return treeDepth;
    }

    private int treeDiameter(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = treeDiameter(root.left);
        int rightDepth = treeDiameter(root.right);

        // 尝试从该节点作为父节点开始,左右最长距离加起来是否为最长距离
        treeDepth = Math.max(treeDepth, leftDepth + rightDepth);

        // 该节点作为路径的一点,取左右最长的的一段给父函数
        return Math.max(leftDepth,rightDepth) + 1;
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
