package com.tang.queue;

import java.util.Scanner;

/**
 * 环形队列
 * 
 * @author tangpeng
 *
 */
public class CycleQueueDemo {

	public static void main(String[] args) {

		CycleQueue queue = new CycleQueue(4);
		char key = ' '; // 接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
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
				case 'a' :
					System.out.println("输入一个数：");
					int value = scanner.nextInt();
					queue.addQueue(value);
					break;
				case 'g' :
					try {
						int res = queue.getQueue();
						System.out.printf("取出的数据是%d\n", res);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'p' :
					int res = queue.peek();
					System.out.printf("队列头的数据是%d\n", res);
				case 'e' :
					loop = true;
					break;
				default :
					break;
			}
		}

	}

}

/**
 * 使用数组模拟环形队列
 * 
 * @author tangpeng
 *
 */
class CycleQueue {
	private int maxSize; // 数组容量
	private int front; // 指向队列头
	private int rear; // 指向队列尾

	private int[] arr; // 数组容器

	public CycleQueue(int maxSize) {
		this.front = 0; // 指向队列的第一个元素
		this.rear = 0; // 指向队的最后一个元素的后一个位置，预留一个空间做约定
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列满，不能加入数据");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;

	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		int result = arr[front];
		front = (front + 1) % maxSize;
		return result;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("没有数据");
			return;
		}
		for (int i = front; i < (front + size()); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	public int size() {
		return (rear - front + maxSize) % maxSize;
	}

	// 显示头数据，不是取头数据
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return front == rear;
	}
}
