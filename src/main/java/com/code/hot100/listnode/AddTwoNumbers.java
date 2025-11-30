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
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = addTwoNumbers.buildNodeList(nums1);
        ListNode l2 = addTwoNumbers.buildNodeList(nums2);
        ListNode head = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(addTwoNumbers.toStringListNode(head));
    }
    public String toStringListNode(ListNode head) {
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

    public ListNode buildNodeList(int[] nums){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i = 0; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return dummy.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int store = 0;
        while(l1 != null || l2 != null || store != 0){
            ListNode node1 = new ListNode();
            ListNode node2 = new ListNode();
            if(l1 != null){node1.val = l1.val;}
            if(l2 != null){node2.val = l2.val;}

            int res = node1.val + node2.val + store;
            store = res / 10;
            res = res % 10;

            cur.next = new ListNode(res);
            cur = cur.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            this.val = x;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
