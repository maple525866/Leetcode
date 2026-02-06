package com.code.realtest.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple
 * @Description
 * @createTime:2026-01-26 14:40
 */
public class TTLLRUCache {
    Map<Integer,DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // 检查是否过期
        if (System.currentTimeMillis() >= node.expireTime) {
            removeNode(node);
            cache.remove(key);
            size--;
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value, long ttlMillis) {
        // 计算当前时间
        long expireTime = System.currentTimeMillis() + ttlMillis;
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value, expireTime);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode removed = moveTailNode();
                cache.remove(removed.key);
                size--;
            }
        } else {
            node.value = value;
            node.expireTime = expireTime;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        DLinkedNode tmp = head.next;

        head.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = head;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode moveTailNode(){
        DLinkedNode node = tail.prev;
        DLinkedNode tmp = tail.prev.prev;
        tail.prev = tmp;
        tmp.next = tail;

        return node;
    }


    private static class DLinkedNode {
        int key;
        int value;
        long expireTime; // 新增：过期时间戳（毫秒）
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode() {}
        DLinkedNode(int key, int value, long expireTime) {
            this.key = key;
            this.value = value;
            this.expireTime = expireTime;
        }
    }
}
