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
        int[] arr = {1,2,2,1};
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode head = isPalindrome.buildListNode(arr);

        System.out.println(isPalindrome.print(head));

        System.out.println(isPalindrome.isPalindrome(head));
    }

    private String print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;

        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append("->");
            }
            curr = curr.next;
        }
        return sb.toString();
    }

    private ListNode buildListNode(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;

        for(int num : nums){
            pre.next = new ListNode(num);
            pre = pre.next;
        }

        return dummy.next;
    }

    private boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;

        while(!stack.isEmpty() && cur != null){
            ListNode node = stack.pop();
            if(!(cur.val == node.val)) return false;

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
