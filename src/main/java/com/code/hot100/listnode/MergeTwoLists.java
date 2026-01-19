package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * @createTime:2025-11-29 22:49
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = mergeTwoLists.buildListNode(nums1);
        ListNode l2 = mergeTwoLists.buildListNode(nums2);

        System.out.println(mergeTwoLists.print(l1));
        System.out.println(mergeTwoLists.print(l2));

        ListNode head = mergeTwoLists.mergeTwoLists(l1, l2);
        System.out.println(mergeTwoLists.print(head));
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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            Integer num1 = l1 != null ? l1.val : null;
            Integer num2 = l2 != null ? l2.val : null;

            if(num1 > num2){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
