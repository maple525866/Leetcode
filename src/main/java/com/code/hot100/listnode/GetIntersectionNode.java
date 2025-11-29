package com.code.hot100.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maple
 * @Description 160.相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * @createTime:2025-11-29 14:01
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode node = new ListNode(3);
        headA.next = node;
        headB.next = node;

        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(headA, headB);
        // 打印出相同的内存地址说明是有相交链表
        System.out.println(intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = headA;
        while(cur != null){
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }

        return null;
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

