package com.from.kunal.kushwah.doublylinkedlist;

public class CustomDoublyLinkedList {

	private Node head;
	// private Node tail;
	private int size;

	public CustomDoublyLinkedList() {
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public Node getNode(int index) {

		if (index == 0) {
			return head;
		}

		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int getNodeValue(Node node) {
		return node.getValue();
	}

	public int gethNodeIndex(Node node) {

		Node temp = head;
		int i=1;
		while (node.next != temp.next) {
			temp = temp.next;
		    i++;
		}

		return i;
	}
	
	public void insertAfterGivenNode(Node node,int value) {
		
		int index = gethNodeIndex(node);
		if(node!=null){
			insert(index, value);	
		}
		
	}
	
	
	public Node searchNode(Node node) {

		Node temp = head;
		while (node.next != temp.next) {
			temp = temp.next;
		}

		return temp;
	}

	public void insertAtFirst(int value) { // it means insert at first index not first insert

		Node node = new Node(value);
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		size++;
	}

	public void insertAtLast(int value) { /// i can also use size

		Node node = new Node(value);
		node.next = null; // cause its last node

		if (head == null) { // list not exist already
			head = node;
			head.prev = null;
			return;
		}
		// now if list exist

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
		node.prev = last;
		// or my solution

		/*
		 * Node temp = head; Node last = null; while(temp!=null) { last = temp; temp =
		 * temp.next; }
		 * 
		 * Node node = new Node(value); if(last == null) { head = node; }else {
		 * last.next = node; } node.next = null; node.prev = last;
		 */
		size++;
	}

	public void insert(int index, int value) {

		if (index == 0) {
			insertAtFirst(value);
			return;
		}
		if (index == (size - 1)) {
			insertAtLast(value);
			return;
		}

		Node temp = head;
		for (int i = 0; i < index - 1; i++) { // 0,1,2
			temp = temp.next;
		}
		Node node = new Node(value);
		node.next = temp.next;
		temp.next = node;
		node.prev = temp;
		node.next.prev = node;
		size++;
	}

	public void displayList() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("");
	}

	public void displayListInRverse() {

		Node temp = head;
		Node prevTemp = null;
		while (temp != null) {
			prevTemp = temp;
			temp = temp.next;
		}
		while (prevTemp != null) {
			System.out.print(prevTemp.value + "<-");
			prevTemp = prevTemp.prev;
		}

		System.out.println("");
	}

	private class Node {

		private int value;
		private Node next;
		private Node prev;

		public Node() {
		}

		public Node(Node next, Node prev) {
			this.next = next;
			this.prev = prev;
		}

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		public int getValue() {
			return this.value;
		}

	}

}
