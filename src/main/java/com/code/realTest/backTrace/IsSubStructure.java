package com.code.realTest.backTrace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 143. 子结构判断
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值
 *
 * 输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
 * 输出：true
 * 解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1
 * @createTime:2026-01-26 13:53
 */
public class IsSubStructure {
    public static void main(String[] args) {
        Integer[] arr1 = {3,6,7,1,8};
        Integer[] arr2 = {6,1};

        IsSubStructure isSubStructure = new IsSubStructure();
        TreeNode A = isSubStructure.buildTree(arr1);
        TreeNode B = isSubStructure.buildTree(arr2);

        System.out.println(isSubStructure.isSubStructure(A, B));
    }

    private String printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res.toString();
    }

    private TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);

        if(root != null) queue.offer(root);

        int i = 1;

        while(!queue.isEmpty() || i < arr.length) {
            TreeNode node = queue.poll();

            if(i < arr.length) {
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                i++;
            }

            if(i < arr.length) {
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    private boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;

        return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if(B == null) return true;

        if(A == null) return false;

        return A.val == B.val && dfs(A.left,B.left) && dfs(A.right,B.right);
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
