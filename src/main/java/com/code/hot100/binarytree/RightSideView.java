package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入：root = [1,2,3,null,5,null,4]
 *
 * 输出：[1,3,4]
 * @createTime:2025-12-03 20:03
 */
public class RightSideView {
    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
        Integer[] arr = {1,2,3,null,5,null,4};

        TreeNode root = rightSideView.buildTree(arr);
        System.out.println(rightSideView.printTree(root));
        System.out.println(rightSideView.rightSideView(root).toString());
    }
    private String printTree(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();

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

    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1) res.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    private static class TreeNode{
        Integer val;
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
