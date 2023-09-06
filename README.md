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






