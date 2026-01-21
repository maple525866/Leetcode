package com.code.hot100.listnode;

/**
 * @author maple
 * @Description 92.反转链表Ⅱ
 * //反转部分链表
 * //1->2->3->4->5
 * //开始 2 结束 4
 * //
 * //反转之后：
 * //1->4->3->2->5
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @createTime:2025-11-26 15:33
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        int[] arr = {1,2,3,4,5};

        ListNode head = reverseBetween.buildListNode(arr);
        System.out.println(reverseBetween.print(head));

        head = reverseBetween.reverseBetween(head,2,4);
        System.out.println(reverseBetween.print(head));
    }

    private String print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;

        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append("->");
            }
            curr = curr.next;
        }
        return sb.toString();
    }

    private ListNode buildListNode(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;

        for(int num : nums){
            pre.next = new ListNode(num);
            pre = pre.next;
        }

        return dummy.next;
    }

    /**
     * 这里采用了25. K 个一组翻转链表的方法
     * @param head
     * @param left
     * @param right
     * @return ListNode
     */

    private ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        for(int i = 0; i < left; i++){
            cur = cur.next;
        }

        ListNode tail = dummy;

        for(int i = 0; i < right; i++){
            tail = tail.next;
        }

        ListNode prev = tail.next;

        while(prev != tail){
            ListNode tmp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = tmp;
        }

        ListNode node = dummy;
        for(int i = 1; i < left; i++){
            node = node.next;
        }

        node.next = prev;

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

