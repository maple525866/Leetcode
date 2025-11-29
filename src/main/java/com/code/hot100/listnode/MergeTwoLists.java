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
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode list1 = mergeTwoLists.buildListNode(nums1);
        ListNode list2 = mergeTwoLists.buildListNode(nums2);
        ListNode listNode = mergeTwoLists.mergeTwoLists(list1, list2);

        System.out.println(mergeTwoLists.toStringListNode(listNode));
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

    public ListNode buildListNode(int[] nums){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i = 0; i<nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) {
            this.val = x;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
