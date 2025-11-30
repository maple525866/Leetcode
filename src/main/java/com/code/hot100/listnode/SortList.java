package com.code.hot100.listnode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple
 * @Description 148.排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * @createTime:2025-11-30 23:55
 */
public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        int[] nums = {4,2,1,3};
        ListNode head = sortList.buildListNode(nums);

        System.out.println(sortList.toStringList(sortList.sortList(head)));
    }

    public String toStringList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if(cur.next != null) sb.append("->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        for(int i = 0; i<nums.length; i++){
            pre.next = new ListNode(nums[i]);
            pre = pre.next;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);

        cur = dummy;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
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
