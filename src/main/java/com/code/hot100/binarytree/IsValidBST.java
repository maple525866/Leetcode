package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 *
 * 输入：root = [2,1,3]
 * 输出：true
 * @createTime:2025-12-03 16:07
 */
public class IsValidBST {
    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        Integer[] arr = {2,1,3};
        TreeNode root = isValidBST.buildTree(arr);
        System.out.println(isValidBST.printBST(root));

        System.out.println(isValidBST.isValidBST(root));
    }

    private String printBST(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
        }
        return list.toString();
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

    private boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        return helper(root,null,null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;

        if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
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
