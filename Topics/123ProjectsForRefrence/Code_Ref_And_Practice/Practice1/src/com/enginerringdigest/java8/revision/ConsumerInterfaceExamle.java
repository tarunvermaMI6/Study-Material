package com.enginerringdigest.java8.revision;

import java.util.function.Consumer;

public class ConsumerInterfaceExamle {

	public static void main(String[] args) {

		// consumer, consume/use the input nothing else
		
		Consumer<Integer> consumer = x->System.out.println(x+x);
	//	consumer.accept(10);
		
		Consumer<Integer> consumer1 = y->System.out.println(y*y);
		
		Consumer<Integer> both = consumer.andThen(consumer1);
		both.accept(5); // take the same input
	} 
}
