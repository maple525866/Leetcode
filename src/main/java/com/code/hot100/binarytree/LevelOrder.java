package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * @createTime:2025-12-02 21:22
 */
public class LevelOrder {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        LevelOrder levelOrder = new LevelOrder();
        TreeNode root = levelOrder.buildTree(arr);
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        System.out.println(lists.toString());
    }

    private TreeNode buildTree(Integer[] arr) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.addLast(root);

        int i = 1;
        while(!queue.isEmpty() && arr.length > i) {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
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
