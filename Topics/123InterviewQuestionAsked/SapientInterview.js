
Ques:

1) Tell me about prototype and session scope

    Ans:  * bean will get create everytime you call bean method ex: bean1 = context.getBean(abc.class), otherwise you can integrate prototype scope into singleton class in that bean 
	      will get create during startup and every you call the function 
	      * bean get creates per user session, gloabl session is like a bean shared by all the gloabl objects , true in the case of web apps

2) Hashmap Working
   
   Ans: 1) array of buckets
        2) buckets have linked list or tree for high collison (https://media.geeksforgeeks.org/wp-content/uploads/Hashmap_working_3.jpg)
		3) compute hashcode() of the key to get index of array of bucket , index = hash(key) % capacity
		4) (collison) but there is situation where hashcode could be same for diffrent key , than if it generates the same index the value will get stored in the index but in linkedlist in next 
		   node
        5) after certain point of collison (8) the linked list will convert to Red-Black Tree
		6) complexity: O(n)
		7) if multiple values stored in same index , the value will search(Linear Search) by key (equals method) in linked list.
		8) If collision count > 8, it converts the linked list into a Red-Black Tree to improve performance from O(n) to O(log n)
		9) Default Capacity = 16 (buckets),Default Load Factor = 0.75,When size > capacity * loadFactor, HashMap resizes (doubles capacity and rehashes all elements).
		10) O(log n) (Tree) or O(n) (LL)
		11) O(1) lookup in best case, O(log n) in worst case.
		12) How put working : Computes hashCode() of the key to determine the bucket index.
                              Checks if the key already exists in that bucket: (use linear search)
                              If key exists, overwrites the value.
                              If key does not exist, adds a new Node<K, V>.
                              Handles collisions using Linked List (before Java 8) or Red-Black Tree (Java 8+).
		    
		
3) Working of HashSet

      Ans: 	HashMap he use karta hai bc put(key, DUMMY_VALUE), value ko as a key leta hai and dummy vaule daal deta hai , same working as Hashmap
	  

4)  Working of Treemap --  store keys in asc sorted order , O(log n), implemented using a Red-Black Tree

    Ans: Uses a Red-Black Tree (Self-Balancing BST)

         Each key-value pair is stored as a node in a Red-Black Tree.

         Keys are always sorted in natural order (Comparable) or by a custom Comparator.

         Insertion (put(K, V))
	  
	     Computes the correct position in the tree based on sorting.

         If key exists, updates the value.

         If key does not exist, inserts a new node and rebalances the tree.
		 
5) Working of HashSet 
    
      Ans: Use treemap internally , store value as key and dummy value as value	
	  
6) How Kafka handle exceptions
    
    Ans: 
      Kafka Producer – Use callback functions, retry mechanisms, and acks settings.
      Kafka Consumer – Use try-catch, commit carefully, and consider dead-letter topics.
      Kafka Streams – Use exception handlers for serialization & processing errors.
      Kafka Connect – Use DLQ and error-handling configurations.	

7)  Executer Framework, thread pools, type of thread pool, future , compatible future , how to know if task is done , submit method   


     // thread pools
	 
	 A Thread Pool is a pool of pre-created worker threads that efficiently execute multiple tasks instead of creating a new thread for each task. This helps improve performance 
	 and resource utilization in multi-threaded applications.
	 
	 // Executer Framework
	 
	 ExecutorService executor = Executors.newFixedThreadPool(5);
	 
	 for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulating work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
		
		executor.shutdown(); // Graceful shutdown after tasks complete
		
// Types of Thread Pools in Java

1. Fixed Thread Pool (Executors.newFixedThreadPool(n))

Creates a thread pool with a fixed number of threads.

Best for CPU-intensive tasks.

2. Cached Thread Pool (Executors.newCachedThreadPool())

Creates threads as needed but reuses idle threads.

Good for short-lived tasks but can lead to resource exhaustion if not used properly.

3. Single Thread Executor (Executors.newSingleThreadExecutor())

Creates a single-threaded pool that executes tasks sequentially.

Useful when tasks must be executed in order.

4. Scheduled Thread Pool (Executors.newScheduledThreadPool(n))

Executes tasks after a delay or at fixed intervals.

Used for scheduled tasks (e.g., cron jobs).	
    
	

// Future

Future is an interface in Java used for handling the result of an asynchronous computation. When you submit a task to an ExecutorService, it returns a Future object that allows 
you to:
✔ Check if the task is completed.
✔ Retrieve the result when available.
✔ Cancel the task if needed.    
	  
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submitting a task that returns a result
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Calculating...");
            Thread.sleep(2000);
            return 42;
        });

        try {
            // Do something else while waiting...
            System.out.println("Waiting for result...");
            
            // Get the result (blocks if not completed)
            Integer result = future.get();  
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
    
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  