package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode node = lowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(lowestCommonAncestor.printTree(node));
    }
    private String printTree(TreeNode root) {
        if (root == null) return null;

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                res.add(node.val);
            }
        }
        return res.toString();
    }


    private TreeNode buildTree(Integer[] arr){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        if(root != null) queue.addLast(root);

        int i = 1;
        while(!queue.isEmpty() || i < arr.length){
            TreeNode node = queue.removeFirst();

            if(i < arr.length){
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    queue.addLast(node.left);
                }
                i++;
            }

            if(i < arr.length){
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    queue.addLast(node.right);
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
        if(root == null) return null;

        if(root == p || root == q) return root;

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
