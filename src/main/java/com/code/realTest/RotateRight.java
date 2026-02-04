package com.code.realTest;

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

        head = rotateRight.rotateRight(head,2);

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
        if (head == null) return null;

        int count = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }

        k = k % count;
        cur = head;
        int[] arr = new int[count];
        for(int i = 0; i < count; i++){
            arr[i] = cur.val;
            cur = cur.next;
        }

        int[] res = new int[count];
        for(int i = 0; i < count; i++){
            res[i] = arr[i];
        }

        for(int i = 0,j = count - k; j < count; i++,j++){
            res[i] = arr[j];
        }

        for(int i = k,j = 0; i < count; i++,j++){
            res[i] = arr[j];
        }

        cur = head;

        int index = 0;
        while(cur != null){
            cur.val = res[index];
            index++;
            cur = cur.next;
        }

        return head;
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
