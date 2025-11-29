package com.code.hot100.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple
 * @Description
 * @createTime:2025-11-29 20:22
 */
public class DetectCycle {
    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node1;
        System.out.println(detectCycle.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode cur = head;

        while(cur != null){
            if(!map.containsKey(cur)){
                map.put(cur,1);
                cur = cur.next;
            }else{
                return cur;
            }
        }

        return null;
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
