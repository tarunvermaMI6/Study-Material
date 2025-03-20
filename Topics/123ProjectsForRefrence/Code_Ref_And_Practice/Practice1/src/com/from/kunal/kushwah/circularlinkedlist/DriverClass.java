package com.from.kunal.kushwah.circularlinkedlist;

public class DriverClass {

	public static void main(String[] args) {
		
		CustomCircularLinkedList list = new CustomCircularLinkedList();
       // list.insertFirst(1);
      //  list.insertFirst(2);
     //   list.insertFirst(3);
    //    list.insertFirst(4);
        list.insertFirst(5);
        list.display();
        list.delete(0);
        list.display();
		System.out.println();
	}
}
