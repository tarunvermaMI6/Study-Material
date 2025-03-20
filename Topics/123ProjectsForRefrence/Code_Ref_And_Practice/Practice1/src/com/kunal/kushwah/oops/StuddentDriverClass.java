package com.kunal.kushwah.oops;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StuddentDriverClass implements Comparator<Students>{

	public static void main(String[] args) {
		
		List<Students> list = new ArrayList<>();
		Students st1 = new  Students(5,"tarun");
		Students st2 = new  Students(10,"tarun");
		Students st3 = new  Students(15,"tarun");
		Students st4 = new  Students(20,"tarun");
		Students st5 = new  Students(25,"tarun");
		Students st6 = new  Students(30,"tarun");
		Students st7 = new  Students(40,"tarun");
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		list.add(st5);
		list.add(st6);
		list.add(st7);
		
		list.sort(new Comparator<Students>() {

			@Override
			public int compare(Students o1, Students o2) {
				int diff =  -(int)(o1.getMarks()-o2.getMarks()); // if it's 0 = equal if it's less than 0 means o2>o1
				return diff;
			}
		});
		System.out.println("list === "+list);
		StuddentDriverClass call = new StuddentDriverClass();
	  	call.compare(st1, st2);
	  
	}

	@Override
	public int compare(Students o1, Students o2) {
		
		int diff = o1.getMarks()-o2.getMarks(); // if it's 0 = equal if it's less than 0 means o2>o1
		System.out.println("diff === "+diff);
		return diff;
	}
}
