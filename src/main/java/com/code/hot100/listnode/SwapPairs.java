package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 24.两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 * @createTime:2025-11-30 17:06
 */
public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        int[] nums = {1,2,3};
        ListNode head = swapPairs.buildListNode(nums);

        System.out.println(swapPairs.toStringList(head));

        head = swapPairs.swapPairs(head);

        System.out.println(swapPairs.toStringList(head));
    }

    public String toStringList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;

        while (cur != null) {
            sb.append(cur.val);
            if(cur.next != null){
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i = 0; i<nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        while(pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;

            ListNode temp = node2.next;
            pre.next = node2;
            node2.next = node1;
            node1.next = temp;

            pre = node1;
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
