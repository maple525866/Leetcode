package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 19.删除链表倒数第n个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @createTime:2025-11-30 16:16
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        int[] nums = {1,2,3,4,5};
        ListNode head = removeNthFromEnd.buildListNode(nums);
        System.out.println(removeNthFromEnd.toStringList(head));
        head = removeNthFromEnd.removeNthFromEnd(head,2);
        System.out.println(removeNthFromEnd.toStringList(head));
    }
    private String toStringList(ListNode head){
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while(cur != null){
            sb.append(cur.val);
            if(cur.next != null){
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    private ListNode buildListNode(int[] nums){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        int total = 0;

        // 1.先来数总共有多少个节点
        while(cur != null){
            total++;
            cur = cur.next;
        }

        cur = dummy;
        // 2.找到要删除节点的前一个节点
        for(int i = 0; i < total - n; i++){
            cur = cur.next;
        }
        // 3.更改前一个节点的next到temp即可
        ListNode temp = cur.next.next;
        cur.next = temp;

        return dummy.next;
    }
    private static class ListNode{
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
