package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 25. K 个一组翻转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * @createTime:2025-11-30 19:52
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        int[] nums = {1,2,3,4,5,6};

        ListNode head = reverseKGroup.buildListNode(nums);
        System.out.println(reverseKGroup.toStringList(head));
        head = reverseKGroup.reverseKGroup(head, 2);
        System.out.println(reverseKGroup.toStringList(head));
    }

    public String toStringList(ListNode head) {
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

        for(int i = 0; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        // cur 代表当前需要反转的链表第一个节点
        while(cur != null){
            // tail 代表当前需要反转的链表最后一个节点
            ListNode tail = prev;
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }

            // 保留下一个区间的第一个节点
            ListNode nex = tail.next;
            ListNode[] nodes = myReverse(cur,tail);
            cur = nodes[0];
            tail = nodes[1];

            prev.next = cur;
            tail.next = nex;

            prev = tail;
            cur = tail.next;
        }

        return dummy.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode cur = head;

        while(prev != tail){
            ListNode store = cur.next;
            cur.next = prev;
            prev = cur;
            cur = store;
        }
        return new ListNode[]{tail, head};
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
