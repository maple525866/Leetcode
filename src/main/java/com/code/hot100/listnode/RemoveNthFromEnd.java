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
        // 快指针先走n步就是从头到了对称第n个节点的节点
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先走 n+1 步（多走1步是为了让 slow 停在待删节点的前驱）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast 和 slow 同步走到末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时 slow 恰好停在待删节点的前驱
        slow.next = slow.next.next;

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
