package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @createTime:2025-11-29 16:12
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ReverseList reverseList = new ReverseList();
        ListNode head = reverseList.buildListNode(arr);
        System.out.println(reverseList.printList(head));

        head = reverseList.reverseList(head);
        System.out.println(reverseList.printList(head));
    }
    private String printList(ListNode head) {
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
        ListNode pre = dummy;

        for (int num : nums) {
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode store = cur.next;
            cur.next = pre;
            pre = cur;
            cur = store;
        }

        return pre;
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
