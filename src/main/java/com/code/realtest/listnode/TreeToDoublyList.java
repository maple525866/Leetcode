package com.code.realtest.listnode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description LCR 155. 将二叉搜索树转化为排序的双向链表 (pdd秋招)
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 *
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,5,1,3]
 *
 *
 * 输出：[1,2,3,4,5]
 * @createTime:2026-08-31 21:05
 */
public class TreeToDoublyList {
    public static void main(String[] args) {

    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();

        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.peek();
            if(node != null){
                stack.poll();
                if(node.right != null) stack.push(node.right);

                stack.push(node);
                stack.push(null);

                if(node.left != null) stack.push(node.left);
            }else{
                stack.poll();
                res.add(stack.poll());
            }
        }

        Node dummy = new Node();
        Node pre = dummy;

        for(Node node : res){
            pre.right = node;
            node.left = pre;
            pre = node;
        }

        pre.right = dummy.right;
        dummy.right.left = pre;

        return dummy.right;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
