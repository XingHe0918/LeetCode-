package org.example;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head,end;

    Node p;
    class Node{
        Node prt;
        Node next;
        int key;
        int val;
        public Node(){}
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int C;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.end = new Node();
        head.next = end;
        end.prt = head;
    }

    public int get(int key) {
        p = map.get(key);
        if (p == null)return -1;
        moveHead();
        return p.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)){
            p = map.get(key);
            p.val = value;
            moveHead();
        } else {
            if (C == capacity){
                map.remove(end.prt.key);
                end.prt.prt.next = null;
                end = end.prt.prt;
                C--;
            }
            Node item = new Node(key,value);
            map.put(key,item);
            item.next = head.next;
            item.prt = head;
            Node P = head;
            while (P != null){
                System.out.println(P.key);
            }
            head.next.prt = item;
            head.next = item;
            C++;
        }

    }

    public void moveHead(){
        p.prt.next = p.next;
        p.next.prt = p.prt;
        head.next.prt = p;
        p.next = head.next;
        head.next = p;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
