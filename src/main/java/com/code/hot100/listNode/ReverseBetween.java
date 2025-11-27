package com.code.hot100.listNode;

/**
 * @author maple
 * @Description
 * @createTime:2025-11-26 15:33
 */
//反转部分链表
//1->2->3->4->5
//开始 2 结束 4
//
//反转之后：
//1->4->3->2->5

//92.反转链表Ⅱ
public class ReverseBetween {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = reverseBetween.createList(nums);

        System.out.println(listToString(head));

        head = reverseBetween.reverseBetween(head,2,6);

        System.out.println(listToString(head));
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

    // 辅助方法：将链表转为字符串，便于打印
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        // 1. 确定反转范围前一个点
        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode cur = prev.next;
        ListNode pre = null;

        for(int i = 0; i <= right-left; i++){
            ListNode store = cur.next;
            cur.next = pre;
            pre = cur;
            cur = store;
        }

        prev.next = pre;
        start.next = cur;

        return dummy.next;
    }
}
class ListNode{
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
