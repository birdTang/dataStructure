package com.tang.stack;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 基于链表的栈
 * @author tangp
 * @date 2020-04-22 23:30;
 */
public class LinkStackDemo {
    public static void main(String[] args) {
        LinkStack stack = new LinkStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.list();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.list();
    }
}

class LinkStack {
    private int maxSize;
    private Node head;
    private int size = 0;

    public LinkStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void push(int val) {
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        Node node = new Node(val);
        node.setNext(head);
        head = node;
        size++;
    }

    public Node pop() {
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        Node node = head;
        head = head.getNext();
        size--;
        return node;
    }

    public void list() {
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node cur = head;
        while (cur!=null){
            System.out.println(cur.toString());
            cur = cur.getNext();
        }
    }
}


class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


