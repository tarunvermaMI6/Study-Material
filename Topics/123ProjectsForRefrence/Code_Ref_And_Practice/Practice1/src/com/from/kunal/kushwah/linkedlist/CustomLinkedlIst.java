package com.from.kunal.kushwah.linkedlist;

public class CustomLinkedlIst {

	private Node head;
	private Node tail;
	private int size;

	public CustomLinkedlIst() {

		this.size = 0;
	}

	public void addAtBeginning(int value) { // head will shift

		Node node = new Node(value);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public int getSize() {
		return size;
	}

	public void addAtEnd(int value) { // tail will shift

		if (tail == null) {
			addAtBeginning(value); // have to insert at the beginning before insert at the end
			return;
		}
		Node node = new Node(value);
		tail.next = node;
		tail = node;

		size++;
	}

	public void addAtEndIfNotMaintaingTail(int value) {

		Node temp = head;
		Node tailTemp = null;
		while (temp != null) {
			tailTemp = temp;
			temp = temp.next;
		}
		// now at the end this temp become tail
		Node node = new Node(value);
		tailTemp.next = node;

		tail = node;
		size++;
	}

	public void insertAtIndex(int value, int index) {

		if (index == 0) {
			addAtBeginning(value);
			return;
		}
		if (index == size-1) {
			addAtEnd(value);
			return;
		}

		int count = 1;
		Node temp = head;

		while (count < index) {
			temp = temp.next;
			count++;
		}

		Node node = new Node(value);
		node.next = temp.next;
		temp.next = node;
		size++;

	}

	public int deleteFirst() { // means head

		int value = head.value;
		head = head.next;
		if (head == null) { // means only one digit exist
			tail = null;
		}

		size--;
		return value;
	}

	public int deleteLast() { // means tail

		int value = tail.value;
		Node temp = head;
		for (int i = 1; i < size - 1; i++) {
			temp = temp.next;
		}
		temp.next = null;
		size--;
		return value;
	}

	public void delete(int index) {

		if (index == 0) {
			deleteFirst();
			return;
		}

		if (index == (size)) {
			deleteLast();
			return;
		}
		
		Node prev = getNode(index-1); // one before index
		prev.next = prev.next.next;  // removing ref from middle node
		// or
	/*	Node temp = head;
		Node tailTemp = null;
		for (int i = 1; i <= index; i++) {
			tailTemp = temp;
			temp = temp.next;
		}
		tailTemp.next = temp.next; */
		size--;
	}

	public Node getNode(int index) {

		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException("index out of bound");
		}		
		if (index == 0) {
			return head;
		}
		if (index == size) {
			return tail;
		}

		Node temp = head;
		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void printAll() {

		Node temp = head; // need to take temp to store the moving head value
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;

		}

		System.out.println("");
	}

	private class Node {

		private int value;
		private Node next;

		public Node() {
		}

		public Node(int value) {
			this.value = value;

		}

	}
}
