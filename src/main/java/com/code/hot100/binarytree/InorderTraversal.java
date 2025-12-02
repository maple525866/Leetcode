package com.code.hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 94. 二叉树的中序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * @createTime:2025-12-01 17:06
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal solution = new InorderTraversal();
        List<Integer> result = solution.inorderTraversal(root);

        // 输出结果
        System.out.println(result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

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
                res.add(stack.poll().val);
            }
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
