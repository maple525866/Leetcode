package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * @createTime:2025-11-30 15:47
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums1 = {9,9,9,9,9,9,9};
        int[] nums2 = {9,9,9,9};

        ListNode head1 = addTwoNumbers.buildListNode(nums1);
        ListNode head2 = addTwoNumbers.buildListNode(nums2);

        ListNode head = addTwoNumbers.addTwoNumbers(head1, head2);
        System.out.println(addTwoNumbers.print(head));
    }

    private String print(ListNode head){
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

    private ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int store = 0;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;

        while(l1 != null || l2 != null || store != 0){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + store;
            pre.next = new ListNode(sum % 10);
            store = sum / 10;
            pre = pre.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
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
