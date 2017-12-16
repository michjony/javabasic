package com.michjony.basic.thinkingjava.generics;

/**
 * 堆栈类,内部链式存储
 * 
 * @since 2017年12月16日
 */
public class LinkedStack<T> {

	private int size = 0;

	// 节点类 , 存储数据
	private class Node {
		T item; // 节点当前存储的值
		Node next; // 当前节点的下一个节点

		Node() {
			this.item = null;
			this.next = null;
		}

		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	// 末端哨兵
	private Node top = new Node();

	// 入栈
	public void push(T item) {
		top = new Node(item, top);
		++size;
	}

	// 出栈
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
			size--;
		}
		return result;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "hello world body".split(" ")) {
			lss.push(s);
		}
		System.out.println(lss.size);
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
		System.out.println(lss.size);
	}
}
