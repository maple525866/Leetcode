package com.code.hot100.listnode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple
 * @Description 23. 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @createTime:2025-12-01 15:19
 */
public class MergeKLists {
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        int[] arr1 = {1,4,5};
        int[] arr2 = {1,3,4};
        int[] arr3 = {2,6};
        ListNode[] nodes = new ListNode[3];
        nodes[0] = mergeKLists.buildListNode(arr1);
        nodes[1] = mergeKLists.buildListNode(arr2);
        nodes[2] = mergeKLists.buildListNode(arr3);

        System.out.println(mergeKLists.toStringList(mergeKLists.mergeKLists(nodes)));
    }
    public String toStringList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append("->");
            }
            head = head.next;
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

    /**
     * 全部链表已经按升序排好，我们可以按照最小堆来做，逐个排序即可
     * @param lists 多个升序链表
     * @return 整个已经排好序的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 1.建立一个最小堆来使用
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode head : lists) {
            // 2.排除空的链表节点数组
            if(head != null) {
                queue.add(head);
            }
        }

        ListNode dummy = new ListNode();
        ListNode pre = dummy;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();

            // 3.某个节点的下一个可能比之前先进堆的还要小，所以先入堆. 下一次循环就可以拿更小的出来
            if(node.next != null){
                queue.add(node.next);
            }

            pre.next = node;
            pre = pre.next;
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
