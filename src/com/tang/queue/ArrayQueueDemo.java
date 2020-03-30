package com.tang.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("a(add):添加数据到队列 ");
			System.out.println("g(get):从队列取数据");
			System.out.println("p(peek):显示队列头数据");
			System.out.println("e(exit)：退出程序"); 
			
			key = scanner.next().charAt(0);
			
			switch (key) {
				case 's' :
					queue.showQueue();
					break;
				case 'a':
					System.out.println("输入一个数：");
					int value = scanner.nextInt();
					queue.addQueue(value);
					break;
				case 'g':
					try {
						int res = queue.getQueue();
						System.out.printf("取出的数据是%d\n",res);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'p':
					int res = queue.peek();
					System.out.printf("队列头的数据是%d\n",res);
				case 'e':
					loop = true;
					break;
				default :
					break;
			}
		}
	}
}
/**
 * 使用数组模拟队列
 * @author tangpeng
 *
 */
class ArrayQueue {
	private int maxSize; //数组容量
	private int front; //指向队列头
	private int rear; //指向队列尾
	
	private int[] arr; //数组容器
	
	
	
	public ArrayQueue(int maxSize) { 
		this.front = -1;  //指向队列头的前一个位置
		this.rear = -1; //指向队列尾，即队列最后一个位置
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}

	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("队列满，不能加入数据");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[++front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("没有数据");
			return;
		}
		for (int i = front+1; i <= rear; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	//显示头数据，不是取头数据
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front+1];
	}
	
	public boolean isFull() {
		return rear==maxSize-1;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
}
