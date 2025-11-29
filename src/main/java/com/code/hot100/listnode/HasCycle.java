package com.code.hot100.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maple
 * @Description
 * @createTime:2025-11-29 19:56
 */
public class HasCycle {
    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node1;
        System.out.println(hasCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)){
                return true;
            }else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
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
