# Java

Banuprakash C

Full Stack Architect, 

Co-founder Lucida Technologies Pvt Ltd., 

Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/VISA_JAVA

===================================

Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-enterprise-java-and-web-developers

Lombok
java -jar lombok.1.18.26.jar

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit
```

Spring Boot 3 ==> Spring Framework 6.0 ==> needs JDK 17

---------------------

OOP 

Object --> State and behaviour
blueprint: class, function, Type

SOLID Design Principles
S -> Single Responsibility
O --> Open Close Principle
Closed for Change and open for extension
L -> Liskov Substitution Principle

BankingAccount : login() and logout()
SavingsAccount : credit() and debit()
CurrentAccount : credit() and debit()
LoanAccount: ...

Product
    price, name, connectivity
Mobile
Tv
WAshingMachine

I --> Interface seggregation

BankingService
    createAccount()
    blockAccount()
    getTransactions()
    credit()
    getBalance()
    debit()

D --> Dependency Injection

============================

Java --> Technology
Platform ==> Env to execute bytecode

JDK, Kotlin, Groovy
```
Account.java
public class Account {
    private double balance; //state

    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }
}

javac Account.java ---> Account.class [ bytecode ]

AccountExample.java
public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account();
        Account swethaAcc = new Account();

        rahulAcc.deposit(45000);
        swethaAcc.deposit(90000);

        System.out.println(swethaAcc.getBalance());
    }
}

javac AccountExample.java ==> AccountExample.class
```
======

rahulAcc.deposit(45000); ===> deposit(rahulAcc, 45000)

 public void deposit(Account this, double amt) {
        this.balance += amt;
    }

context.behaviour(arguments);

swethaAcc.getBalance()

getBalance(swethaAcc);

For example, the -Xmx256M argument allows the Java heap to grow to 256MB.

java -Xmx256M AccountExample

=============================

```
Need to track how many instances of Account is created?
constructor 
Account.java
public class Account {
    private String accNo; // state
    private double balance; //state
    private static int count; // state of class --> 0

    public Account() {
        accNo = "NA";
        count++;
    }

    // parametrized constructor
    public Account(String accNo, double initialAmt) {
        this.accNo = accNo;
        this.balance = initialAmt;
    }

    public Account(Account other) {
        this.accNo = other.accNo;
        this.balance = other.balance;
    }
    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }

    public static int getCount() {
        return count;
    }
}

javac Account.java ---> Account.class [ bytecode ]

AccountExample.java
public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account();
        System.out.println(Account.getCount()); // 1
        Account swethaAcc = new Account("SA123", 500.00);
        System.out.println(Account.getCount()); // 2
        rahulAcc.deposit(45000);
        swethaAcc.deposit(90000);

        System.out.println(swethaAcc.getBalance());
    }
}
```

Logically grouping of classes in enterprise application
1) entity / domain / model class
they represent business data. 
Uber
Customer, Driver, Vehicle, Payment, Trip
Customer ---> Table of database
constructor, getters, setters, hashCode, equals

2) DAO classes --> Data Access Object
Contains CRUD operations

3) Service classes 
facade over DAO and business logic

4) Exception classes
    to represent any abnormal condition in application
5) Utility classes
    Helpers

6) UI 
    Web / Standalone / Mobile

```

DAO's are generally one per table

class ProductDao {
    CRUD for products table
}

class AccountDao {  
    CRUD for accounts table
}

public class CustomerService {

}

public class AdminService {

}

=========


public class AccountDao {
    updateAccount(Account acc) {

    }

    getBalance() {}
}

public class TransactionDao {
    insertTransaction(Transaction tx) {}
}

facade
public class BankingService {
    public void transferFunds(Account fromAcc, Account toAcc, double amt) {
        Begin TX;
        accDao.getBalance()
        accDao.updateAccount(fromAcc);
        accDao.updateAccount(toAcc);
        transactionDao.insertTransaction(tx);
        sendSMS();
        sendEmail();
        Commit TX / RollBack TX
    }
}

```

package ---> folders

Day 2

Recap:
Object
state and behaviour
instance variable [ heap area], instance methods

class member --> static
static variables --> Metaspace
static methods --> invoke with  class context [no implicit "this"]

constructors
* same name as that of class
* no explicit return type
* can be overloaded

toString() --> object method, className + hashCode

===================

Relatioship between objects
* Generalization and Specialization
* Realization
* Association
* Uses A

Java Tools:
* Checkstyle
  Naming Conventions --> CamelCase
  Constants --> we use SNAKE CASE
  final int MAX_AGE = 100

  comments
  // single
  /*
    multiline
  */

  /**
    API comments
  */
* PMD / findBugs / spotBugs ==> Coding Stds
 * unreachable code
 * empty blocks, empty catch statements, resources not released...

* SONARQube

* Maven / Gradle --> Dependency Management

* Jenkins --> CI / CD pipeline

* JUnit / TestNG --> Unit testing framework

* Git

-------

Generalization and Specialization

``` 
    How methods behave:
    // implicitly extends [ inheritance ] from java.lang.Object
    public class Product {
       public double getPrice() {
            return 100;
       }
       public String getName() {
        return "P1";
       }
    }

    public class Mobile extends Product {
       public double getPrice() {
            return 999;
       }

       public String getConnectivity() {
            return "4G";
       }
    }

   Product p = new Mobile();
   p.getName();
   p.getPrice();
   p.getConnectivity();

p instanceof Object ==> true
p instanceof Product ==> true
p instanceof Mobile ==> true
p instanceof Tv ==> false

(p.getClass() == Tv.class) ==> true
(p.getClass() == Product.class) => false

p.m();



m.invoke(p);

Java doesn't support multiple inheritance

class A extends B, C {} // ERROR

Task 1:

class Time {
    hours, min
    // 
}

class TimeExample {
    public static void main(String[] args) {
        Time t1 = new Time(3,45);
        Time t2 = new Time(2,30);

        Time t3 = Time.add(t1, t2);

        s.o.p(t1.getHours() + " : " + t1.getMin()); // 3 : 45
        s.o.p(t2.getHours() + " : " + t2.getMin()); // 2 : 30
        s.o.p(t3.getHours() + " : " + t3.getMin()); // 6 : 15        
    }
}

Task 2:

Person
    firstName
    lastName

    constructors
    getters
    setters

    boolean isOutstanding()
Student extends Person
    course
    gpa
     constructors
    getters
    setters

    boolean isOutstanding()  GPA > 8.0

Faculty extends Person
    subject
    rating

    constructors
    getters
    setters

     boolean isOutstanding()  rating > 4.25

main()
create array of persons [ 3 ]
list outstanding persons
Use Method to print all details

```
Realization Relationship --> using interface

* One Component/element will realize the behaviour specified by other

public interface EmployeeDao {
    void addEmployee(Employee e); // public and abstract by default
    Employee getEmployee(int id);
}

public class EmployeeDaoRdbms implements EmployeeDao {
    // ...
    public void addEmployee(Employee e) {
        INSERT
    }
    public Employee getEmployee(int id) {
        SELECT
    }
}


public class EmployeeDaoMongodb implements EmployeeDao {
    // ...
    public void addEmployee(Employee e) {
        db.employees.insert(...);
    }
    public Employee getEmployee(int id) {
        db.employees.find({id:id})
    }
}

public class AppService {
    EmployeeDao empDao = new EmployeeDaoMongodb();
}

Why program to interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING


Plants[] getPlants(String season);

=================

DAY 3

Generics --> limited to Object type and not primitive
```
public class Rectangle <T> {
    T width;
    T breadth;
    //
}

Rectangle<Integer> r1 = new Rectangle<>(4,5);
Rectangle<Double> r2 = new Rectangle<>(1.2, 4.2);
Rectangle<String> r3 = new Rectangle<>( "1inch", "3.4inches");


Integer is a wrapper class for int

int x  = 10;

Integer iX = x; // auto-boxing

int y = iX; // unboxing
y++;
```

Java Collection Framework --> Data Containers

array is a data container
* interfaces
* implementation classes
* Algorithm / Utility


List interface:
* ordered
* duplicates are allowed
* supports index based operation
    get(10); remove(3); ...
* re-order is allowed

====

ArrayList list = new ArrayList(); // avoid this, program to interface

List list = new ArrayList(); // avoid this, use generics --> Type Safe
list.add("A");
list.add(new Date());
list.add(34);

if( list.get(i) instanceof String) {
    String s = (String)list.get(i);
}

List<String> list = new ArrayList<>();
list.add("A");
list.add(new Date()); // ERROR

String s = list.get(i);

Comparable : logic is part of object itself

Comparator: logic for comparision is part of client




Arrays

Collections


array of products in SortClient
Arrays.sort(products); // sort by id

Arrays.sort(products, comparator based on name of product);

Arrays.sort(products, comparator based on price of product);

=============

High Order Functions:
1) functions which accept function as argument
2) function returns a function

* treat function as first class member [ just like primitive and object]

map(transformFn) {
    result = [];
        for every elem in elems
           add transformFn(elem) to result
        end for
    return result;  
}

[3, 4, 8, 9 , 11, 20, 40, 12]

e -> e % 2 == 0

e -> e.category().equals("computer");


java 8 streams contain pre-defined HOF
https://rxmarbles.com/

List<Integer> data = Arrays.asList(55,1,66,10,34, 66);



HOF:
PART A : intermediary functions
1) filter
2) map
3) flatMap
4) skip
5) limit

PART B : terminal functions
6) forEach
7) reduce
8) collect

Day 4

Recap
Comparable vs Comparator interfaces

Comparator: Anonymous class / Lambda expression

Lambda expression is valid for Functional Interface [ interface where only one method has to be implemented]

interface Computation {
    int compute(int x , int y);
}

// Anonymous class
Computation c1 = new Computation() {
    public int compute(int x , int y) {
        return x  + y;
    }
};

// lamda 
Computation c2 = (int x , int y) -> {
        return x  + y;
    };

Type Inference: 
Computation c2 = (x, y) ->  x  * y;

----

Arrays: --> utilities like sort, max, min, binerySearch, .. which can be used on [] type of datacontainer, provided data is primitive or Objects stored implements Comparable interface
Or we can use Comparator in the client

Collection
Set, Queue and List extends Collection interface.

List interface
ArrayList / LinkedList / Apache Collections / VAVR, .. implementations of List interface

Collections -> utilities like sort, max, min, binarySearch, .. which can be used on List type of datacontainer, provided data is primitive or Objects stored implements Comparable interface
Or we can use Comparator in the client

-----

Java 8 streams supports HOF.

Intermediary functions:
1) map()
2) filter()
3) flatMap()
4) skip()
5) limit()

Terminal functions:
1) collect()
2) forEach()
3) reduce()

products.stream().filter(predicateFn).map(transformFn).reduce(aggregateFn);

products.stream().map(transformFn).filter(predicateFn).collect(Collectors.toList());

products.stream().limit(20).map(transformFn).filter(predicateFn).forEach(consumerFn);

==============

Map
is a container which stores the data in key/value pairs

* Dictionary
* Registry

Hashtable [ legacy], HashMap, TreeMap, LinkedHashMap,.. ==> implementations of Map interface

Hash based datacontainers uses hashCode() and equals() for identifying duplicates and decide the position in datacontainer

HashStory:
1) 2 similiar objects has to have the same hashcode
2) not similar objects can also have same hashcode [ possibility]

public class Rectangle {
    width; breadth;

    public int hashCode() {
        return width * breadth;
    }
}

Rectangle r1 = new Rectangle(4, 5); // 20
Rectangle r2 = new Rectangle(5, 4); // 20
Rectangle r3 = new Rectangle(10, 2); // 20
Rectangle r4 = new Rectangle(2, 10); // 20
Rectangle r5 = new Rectangle(20, 1); // 20
// collisions

String s1 = new String("Hello"); 
is different from
String s1 = "Hello"; // literal --> String pool

====

* Hash based containers invoke hashCode()
* hashCode() % size of buckets --> decides where data is placed and to find duplicate.
* if hashCode() collides, invoke equals() to check if both have same content or not.
if both have same content --> overwrite the value.
if equals() returns false --> use linked hashing


