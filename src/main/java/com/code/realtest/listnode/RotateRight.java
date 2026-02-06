package com.code.realtest.listnode;

/**
 * @author maple
 * @Description
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * @createTime:2026-02-04 15:21
 */
public class RotateRight {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        RotateRight rotateRight = new RotateRight();
        ListNode head = rotateRight.buildListNode(arr);
        System.out.println(rotateRight.print(head));

        head = rotateRight.rotateRight(head,1);

        System.out.println(rotateRight.print(head));
    }

    private String print(ListNode head){
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
        ListNode prev = dummy;

        for(int num : nums){
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        return dummy.next;
    }

    private ListNode rotateRight(ListNode head,int k){
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 计算长度，并找到尾节点
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }

        // 2. 处理 k
        k = k % count;
        if (k == 0) {
            return head;
        }

        // 3. 找到新的尾节点：第 (count - k) 个节点
        ListNode newTail = head;
        for (int i = 0; i < count - k - 1; i++) {
            newTail = newTail.next;
        }

        // 4. 新头是 newTail.next
        ListNode newHead = newTail.next;

        // 5. 断开并连接
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
