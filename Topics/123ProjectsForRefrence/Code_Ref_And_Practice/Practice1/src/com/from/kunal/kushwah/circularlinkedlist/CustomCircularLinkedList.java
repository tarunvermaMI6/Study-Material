package com.from.kunal.kushwah.circularlinkedlist;

public class CustomCircularLinkedList {

	private int size;
	private Node head;
	private Node tail;

	public int getSize() {

		return this.size;
	}

	public void insertFirst(int value) {

		Node node = new Node(value);
		node.next = head;
		head = node;
		if (tail != null) {
			tail.next = head;
		} else {
			tail = head;
		}
		size++;
	}

	public void deleteFirst() {

		head = head.next;
		if (tail != null) {
			tail.next = head;
		}
	}

	public void delete(int index) {

		if (index == 0) { // delete head
			deleteFirst();
			return;
		}

		Node temp = head;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}

	public void display() {

		Node temp = head;
		if (head != null) {
			do {
				if (temp != null) {
					System.out.print(temp.value + "->");
					temp = temp.next;
				}
			} while (temp != head);
		}
		System.out.println();
	}

	private class Node {

		int value;
		Node next;

		public Node() {

		}

		public Node(int value) {
			this.value = value;
		}
	}
}
