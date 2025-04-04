
ques: 

1) project HLD and explain
2) How you deploy things on aws
3) saga design pattern
4) what microservice design pattern u have used
5) cyclic dependency and how to resolve it
6) @postcontruct

7) 
Employee table 

Id    name   salary  department

Fimd all the department more than 10 employee

select department ,count(department) as count from employee group by department having count > 10;

select distinct department from employee order by salary desc limit 3 // top 3 salary department wise

rank() function, union and union all

8) hasset and hashmap working 
9) string[] array = {"john", "vicky", "robbin", "james"}; // make every first character capital
10) aws : what services you have uses, kubernetics , EBS, edge location,
11) sington pattern , make it serialization safe
12) diffrence between aggreagtion and composition
13) executor framework : how to create thread pool, what is thread pool, types of thread pool, implemnet type of threadpool
14) hashmap and concurrent hashmap
15) java memory model
16) JPA


//Cyclic Dependency & How to Resolve It

📌 What is a Cyclic Dependency?
A cyclic dependency occurs when two or more components (classes, modules, or services) depend on each other directly or indirectly, creating a circular reference. 
This can lead to issues like stack overflow errors, deadlocks, and maintainability problems.


class A {
    B b;

    A(B b) {
        this.b = b;
    }
}

class B {
    A a;

    B(A a) {
        this.a = a;
    }
}
Problem: A depends on B, and B depends on A, creating an infinite loop when instantiating them.

How to Resolve Cyclic Dependency?

1️⃣ Use Dependency Injection (DI)
Instead of directly instantiating objects within the classes, use Dependency Injection (DI) (e.g., via constructor injection).

Solution: Inject Dependencies Through a Third Party
java
Copy
class A {
    B b;
    
    A(B b) {
        this.b = b;
    }
}

class B {
    A a;
    
    B() {}  // Default constructor to break cycle

    void setA(A a) {
        this.a = a;
    }
}

public class Main {
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        b.setA(a);  // Dependency is injected later

        System.out.println("Cyclic dependency resolved!");
    }
}
✔ Why it works?

B is created first without needing A immediately.

A gets B via the constructor.

Later, we set A in B, avoiding cyclic instantiation.

2️⃣ Use Interfaces to Decouple Dependencies
Introduce an interface to break the cycle and implement loosely coupled design.

Solution: Decouple with an Interface
java
Copy
interface Dependency {
    void doSomething();
}

class A implements Dependency {
    public void doSomething() {
        System.out.println("A is doing something!");
    }
}

class B {
    Dependency dependency;

    B(Dependency dependency) {
        this.dependency = dependency;
    }

    void execute() {
        dependency.doSomething();
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.execute();
    }
}
✔ Why it works?

B depends on the Dependency interface instead of A directly.

A implements the interface, breaking the direct cycle.

3️⃣ Use Lazy Initialization (@Lazy in Spring Boot)
In Spring Boot, cyclic dependencies can be resolved using @Lazy.

Example: Spring Boot Cyclic Dependency Issue
java
Copy
@Component
class A {
    private final B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }
}

@Component
class B {
    private final A a;

    @Autowired
    public B(A a) {
        this.a = a;
    }
}
🔴 Spring will throw an error: Circular dependency detected

Solution: Use @Lazy to Delay Initialization
java
Copy
@Component
class A {
    private final B b;

    @Autowired
    public A(@Lazy B b) {
        this.b = b;
    }
}

@Component
class B {
    private final A a;

    @Autowired
    public B(@Lazy A a) {
        this.a = a;
    }
}
✔ Why it works?

The @Lazy annotation tells Spring not to create the object immediately.

It initializes the dependencies only when they are first accessed.

4️⃣ Use Event-Based Communication
Instead of calling each other directly, classes can communicate using events.

Example: Using Events Instead of Direct Calls
java
Copy
class A {
    EventBus eventBus;

    A(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    void doSomething() {
        eventBus.notify("A did something");
    }
}

class B {
    B(EventBus eventBus) {
        eventBus.subscribe(message -> System.out.println("B received: " + message));
    }
}

interface EventBus {
    void notify(String message);
    void subscribe(EventListener listener);
}

interface EventListener {
    void onEvent(String message);
}
✔ Why it works?

No direct dependency between A and B.

A just publishes an event, and B listens for it.

🎯 Key Takeaways
✅ Cyclic dependencies create problems like infinite loops and maintainability issues.
✅ Dependency Injection (constructor/setter injection) helps avoid direct instantiation loops.
✅ Interfaces break tight coupling and promote flexibility.
✅ Lazy initialization (@Lazy) can defer object creation to prevent circular references.
✅ Event-driven communication removes direct dependencies.





















