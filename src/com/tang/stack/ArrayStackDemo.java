package com.tang.stack;

import java.lang.annotation.Retention;

/**
 * 基于数组的栈
 * @author tangp
 * @date 2020-04-22 22:27;
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
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

class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //栈容器
    private int top = -1; //栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty() {
        return top==-1;
    }
    //入栈
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = val;
    }
    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        int val = stack[this.top];
        top--;
        return val;
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i=top;i>=0;i--) {
            System.out.printf("stask[%s]=%s \n",i,stack[i]);
        }
    }
}