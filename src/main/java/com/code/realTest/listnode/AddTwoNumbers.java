package com.code.realTest.listnode;

import com.code.hot100.listnode.MergeTwoLists;
import com.code.hot100.listnode.ReverseBetween;

/**
 * @author maple
 * @Description 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * @createTime:2025-12-15 00:20
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums1 = {7,2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = addTwoNumbers.createList(nums1);
        ListNode l2 = addTwoNumbers.createList(nums2);
        ListNode head = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(addTwoNumbers.toStringListNode(head));
    }

    public String toStringListNode(ListNode head){
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int store = 0;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while(l1 != null || l2 != null || store != 0){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int res = num1 + num2 + store;
            store = res / 10;
            res = res % 10;

            prev.next = new ListNode(res);
            prev = prev.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        ListNode head = dummy.next;

        return reverseList(head);
    }

    public ListNode createList(int[] arr){
        if(arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i=0; i < arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode store = cur.next;
            cur.next = prev;
            prev = cur;
            cur = store;
        }

        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
