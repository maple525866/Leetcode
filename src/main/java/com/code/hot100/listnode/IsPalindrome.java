package com.code.hot100.listnode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 234.回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 * 输入：head = [1,2,2,1]
 * 输出：true
 * @createTime:2025-11-29 16:37
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        int[] arr = {1,2,2,1};
        ListNode head = isPalindrome.buildNodeList(arr);
        System.out.println(isPalindrome.isPalindrome(head));
    }
    public ListNode buildNodeList(int[] nums){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i = 0; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return false;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while(cur.next != null) {
            cur = cur.next;
            stack.push(cur);
        }

        cur = head;
        while(!stack.isEmpty() && cur != null) {
            ListNode node = stack.pop();
            if(node.val != cur.val) return false;
            cur = cur.next;
        }

        return true;
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
