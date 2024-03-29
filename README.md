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

$ docker exec -it  local-mysql bash

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


====

Map<String, List<Product>> productList = new HashMap<>();

productList.put("mobiles", Arrays.asList(new Product(25, "iPhone", 56666.22), new Product(45, "OnePlus", 89000.00)));

productList.put("tv", Arrays.asList(new Product(86, "Sony", 456666.22), new Product(881, "Samsung", 119000.00)));

==========

TreeMap --> won't use hashCode() and equals(). Rather uses Comparable or Comparator to identity duplicates and ordering.
TreeMap is a sorted map [ sorts and stores based on KEY]

Set is a data container with unique elements, unlike List it is not ordered, can't re-order, can't use index based operation

========================
Docker should be working

Exception Handling
Exception: Abnormal condition that arises in application while execution[ Runtime ]

Exception is an Object:
1) What went wrong?
2) Why?
3) Where?

Exceptions/ Throwable are of type "Exception" or "Error" type

Error Type --> Can't provide solution while application is running
Exception type of Exception -> can provide alternate path

```
Exception types are again classified as
1) Checked type of exceptions
    these types of exceptions occur due to reasons outside of JRE.
    Since Exception has already occured in database / filesystem, etc which is propagated to application.
    Compiler --> enforces you to handle ==> try / catch
2) Unchecked type of exceptions
    exceptions like "ArithmeticException", "NullPointerExcetion", "ArrayIndexOutOfBoundsExceptions", ..
    which occur  due to reasons with JRE are unchecked exceptions.
    These exceptions without try / catch --> compiler compiles

    Note: These exceptions are supposed to be handled using conditional statements

    public void addProduct(Product p) {
        if(p != null) {
            // logic
        }
    }

    if( y != 0) {
        res = x / y; 
    }
```

Exception handling syntax has;
Example: i need to read from file and upload the contents to database
```
try {
    // actual code / logic
} catch(SQLException ex) {
    // handle
} catch(IOException ex) {
    // handle
} catch(SecurityException ex) {
    // handle
}

```
"finally" block is a compulsory execute code; executes if exception occurs or not
--> Release resources like "db connection", "socket connection", "file close"
```
try {
    // line 1
    // line 2
    // line 3
} catch(SQLException ex) {
    // handle
} catch(IOException ex) {
    // handle
} catch(SecurityException ex) {
    // handle
} finally {
    close file
    close database
}
```
=================================
Database and Maven

Maven / Gradle
Maven is a build automation tool used primarily for Java projects. 
* Manage dependencies [ 3rd party libraries in project]
* Run run goals / compile, test, deploy ==> automated
* publish your module to repo

Maven brings in standard for java projects ==> easy to use different IDEs 

pom.xml ==> Project Object Model

```

<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.28</version>
    </dependency>
</dependencies>
```
pom.xml
1) dependencies
2) goals

settings.xml
1) local repository
2) remote repo
3) central repo

=========================

docker is a Virtual machine with containers

container => Running application of a image [ software ]


=====================================================================

Java Concurrency
Multi-threaded application

* Process --> Program in execution
Every program needs a unit of work executing ---> Thread

Process withmore than one unit of work ==> Multi threaded

Single Threaded: Notepad

MultiThreaded : Eclipse, Word, Browser, ...

Multi threaded application uses:
1) avoids starvation
2) Optimization of using resources

JVM and Threads

Java and Threads:
1) Runnable interface
```
interface Runnable {
    void run();
}

public class GrammerCheck implements Runnable {
    // state
    // behaviour

    public void run() {

    }
}


public class SpellCheck implements Runnable {
    // state
    // behaviour

    public void run() {

    }
}
```

2) Thread class
to manage life-cycle of thread
a) start()
b) yield()
c) sleep(long ms)
d) interrupt()

Deprecated methods
e) stop()
f) suspend()
g) resume()

Object methods to control threads:
a) wait()
b) notify()
c) notifyAll()

Thread t1 = new Thread(new SpellCheck());
Thread t2 = new Thread(new GrammerCheck());

t2.start();

Mac / Windows are Pre-emptive OS

Solaris --> Non Pre-emptive OS

while(employee exists) {
    update employee BASIC
    update employee HRA
    Thread.currentThread().yield();
}

Day 5

interface Runnable {
    void run();
}

Thread t = new Thread();
t.start();

public class TransactionThread implements Runnable {
    ..
    public void run() {

    }
}

public class TransactionThread extends Thread {
    ..
    public void run() {

    }
}

====================

```
public class TransactionThread implements Runnable {
    //

    @Override
	public void run() {
		if(TransactionType.CREDIT == type) {
			account.deposit(name, amt);
		} else if(TransactionType.DEBIT == type) {
			account.withdraw(name, amt);
		}
	}
}

Thread t1 = new Thread();
t1.start();

Thread t1 = new Thread(new TransactionThread());
t1.start();

```

Thread Safety:
a member is thread safe if it doesn't get corrupted in mult-threaded environment

Local variable: Thread Safe --> Stack
Immutable Objects : Thread Safe ==> Heap area
static variables : Metaspace --> shared by threads --> Not Safe
instance variables: heap -> shared by threads --> not safe

synchronized method
```
public class BankingService {

    public void transferFunds(Account fromAcc, AccountTo, double amt) {

        synchronized(fromAcc) {
            synchronized(toAcc) {
                fromAcc.withdraw(amt);
                toAcc.deposit(amt);
        }
        }
    }
}

// class level lock --> Static data lock
public synchronized static void doTask() {

}
```

ArrayList and LinkedList ==> Not Thread Safe 
Vector , Stack ==> methods are Synchronized

```

List<String> list = new ArrayList<>();

synchronized(list) {

}

List<String> list = new ArrayList<>();
List<String> list2 =  Collections.synchronizedList(list);

===

List<String> list = new CopyOnWriteArrayList();
list.add("A");
list.add("B");

Map<String,Double> map = ConcurrentHashMap<>(100, 0.7f, 10);

Segments: 2 pow x > 10

2 pow 4 ==> 16 segments

```

Docker
Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers. 

```

banuprakash@Banuprakashs-MacBook-Pro VISA_JAVA % docker exec -it  local-mysql bash
bash-4.4# mysql -u root -p
Enter password: 

mysql> create database VISA_DB;

mysql> use VISA_DB;
mysql> create table products(id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);

```

JDBC --> Java Database Connectivity

JDBC provides interfaces; implementation classes are provided by database vendors

Steps:

1) load drivers provided by database vendors
Class.forName("driverClassName");

com.mysql.jdbc.cj.Driver
oracle.jdbc.Driver

2) Establish Connection to Database

Connection con = DriverManager.getConnection(URL, USER, PWD);

jdbc:mysql://localhost:3306/VISA_DB
jdbc:oracle:thin:@localhost:1521:VISA_DB

3) Interact with database
3.1) Statement
SQL is fixed
"select * from products"

3.2) PreparedStatement
depends on IN parameter

"select * from products where id = ?"

insert into products values (0, ?, ?, ?);

3.3) CallableStatement
StoredProcedure

DELIMITER //
CREATE PROCEDURE sp_GetMovies()
BEGIN
    select title,description,release_year,rating from film;
END //
    
DELIMITER ;

Java:

call sp_GetMovies()

4) ResultSet
    The object of ResultSet maintains a cursor pointing to a row of a table. Initially, cursor points to before the first row.

5) finally block close connection

ResultSet executeQuery(); // SELECT
int executeUpdate(); // INSERT, DELETE and UPDATE

======

Day 6

IntelliJ

File --> New Project

Name: db
Location: Where projects reside [ workspace ]
java
Maven
+ Add SDK --> select JDK installed folder

Add Dependencies:
https://mvnrepository.com/


folder of Project> mvn clean install

======

Web application Development [HTTP protocol]

JavaEE --> Enterprise Application

Servlet engines:
Tomcat / Jetty / Netty
```
Deployment Descriptor: web.xml

public class LoginServlet extends HttpServlet {

}

web.xml
<servlet>
    <servlet-name>First</servlet-name>
    <servlet-class> com.visa.prj.web.LoginServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>First</servlet-name>
    <url-pattern>/login</url-pattern>
</servlet-mapping>

```
Servlet 2.5+

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOExcpetion, ServletException {
        //
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOExcpetion, ServletException {
        //
    }
}

HTTP methods: GET, POST, PUT, PATCH, DELETE, ..


Engine needs data in "war" format

Web Archive [war]

mvn jetty:run


JSP : Translation Phase --> gets converted to Servlet [ first time or any changes to JSP]

Request Processing Phase -> make request to JSP, servlet is invoked

    public void _jspService(HttpServletRequest req, HttpServletResponse res) .. {

    }

```
<%@ page import="java.util.List" %>
<%@ page import="com.visa.prj.entity.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 14/09/23
  Time: 11:23 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            for(Product p : products) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getPrice() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>

```

SSRedirection vs CSRedirection

Session Tracking
Http protocol is a stateless protocol

Session Tracking is the capability given to web application to keep track of conversational state of client

HttpSession API

HttpSession ses = req.getSession(true);
Create a session if not exists; get session if it exists


HttpSession ses = req.getSession(false); // get session if it exists

ses.invalidate(); // terminate the session --> logout

ses.setMaxInactiveInterval(seconds); // default is 20 min or 30 min

ses.setAttribute(key , value);

ses.getAttribute(key);

ses.removeAttribute(key);

Day 8

Web Server [ handles HTTP request and serve Static content / Load Balancer,..]

Servlet engine / Web Container / Servlet Container ==> serve dynamic content genrated using Java

Servlet engine manages life-cycle of objects
* Servlet instances and maps it to URL [ Singleton]
* Thread pool for handling requests 
* creates Request and Response objects for every client request, destroyed once response is commited to client

JakarataEE with "web" template, "java", "Maven" --> servlet api
pom.xml --> jetty or tomcat plugin for embedded web container 

Servlet --> Controller --> *.do
Model -> Business Data and logic
JSP ==> Views

JSP 
<%
    scriptlets --> java statements
%>

<%= expression %> --> write output

JSTL --> 

<%@ taglib uri="" prefix="c">

<c:forEach items="${products}" var="product">
</c:forEach>

========

${user}

* pageScope
* requestScope
* sessionScope
* applicationScope

JSP implicit objects:
* page 
* request --> HttpServletRequest
* session --> HttpSession
* application --> ServletContext
* out ==> JSPWriter
* param

Listeners ==> invoked by Servlet Engine based on events
* ServletContextListener
* HttpSessionListener
* HttpSessionAttributeListener

JSP and Servlet are invoked using URL pattern --> Client makes a request

Listeners ==> invoked by Servlet Engine based on events

Filter ==> Interceptor pattern
* common headers like [cache, cross-origin, locale ] for all pages

```
<%
response.setIntHeader("max-age", 0); //IE only;
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.addHeader("Cache-Control","no-store");
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setIntHeader ("Expires", -1); //prevents caching at the proxy server
response.addHeader("cache-Control", "private"); //IE5.x only;
%>
```
* Security
```
    <%
        Session ses = request.getSession();
        if(ses.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
```

* Encrpty / decrpt, ..

```
<filter-mapping>
  <filter-name>securityFilter</filter-name>
  <url-pattern>*.jsp</url-pattern>
</filter-mapping>

<filter-mapping>
  <filter-name>zipFilter</filter-name>
  <url-pattern>*.do</url-pattern>
</filter-mapping>
```

Task 1:
MultiStage Form Submission

Task 2:
    1) Context will have teams with passwords
        "rcb", name, password
        "Mumbai Indians", ...

    2) Context has players
        Player
            id, name, skill, basePrice, sold [ boolean ]

    3) Each team login
        playerlist
        once player is selected for a team, player is not availble for auction [ sold --> true]

    4) 12 players for auction
        3 teams are there --> each team can have ma of 4 players 


1) We should have teams and players available for all users/teams

class Team {
    name,
    username,
    password,
    budget
    List<Player> players = new ArrayList<>();
}

class Player {
    name,
    skill,
    basePrice,
    sold
}

ContextListener
    contextInitialized(SCE sce) {
        List<Team> teams = new ArrayList<>();
        teams.add(...);
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("teams", teams);

        List<Player> players = ..
         ctx.setAttribute("players", players);
    }

2) team has to login
    login.jsp --> login.do --> FrontController
    place the team in HttpSession

    redirect to listPlayers.jsp [ display available players]
    Welcome RCB, available Budget: ....
    Selected Players;
    1,
    2

    Available Players:
    P1 skill base_price [radio button]
    P2 skill base_price [radio button]
    P3 skill base_price [radio button]

    TEXT BOX for BID Amount

    Button "Select"

    "addPlayer.do"
    1) add selected player to "players" field of Team [  check max players, bid should be more than base_price, check budget]
    2) remove "player" from "players" context attribute

```
Test Link:
https://www.classmarker.com/online-test/start/?quiz=dmj6507cf61d5e84

```