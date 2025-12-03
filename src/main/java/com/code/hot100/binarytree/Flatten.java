package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * @createTime:2025-12-03 20:48
 */
public class Flatten {
    public static void main(String[] args) {
        Integer[] arr = {1,2,5,3,4,null,6};
        Flatten flatten = new Flatten();
        TreeNode root = flatten.buildTree(arr);
        flatten.flatten(root);
        System.out.println(flatten.printTree(root));
    }
    private String printTree(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
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

    private TreeNode buildTree(Integer[] arr){
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.addLast(root);

        int i = 1;
        while(!queue.isEmpty() && i < arr.length){
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

    private void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();

                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            }else{
                stack.pop();
                list.add(stack.pop());
            }
        }

        int size = list.size();
        for(int i = 1; i < size; i++){
            TreeNode p = list.get(i - 1);
            TreeNode q = list.get(i);
            p.left = null;
            p.right = q;
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
