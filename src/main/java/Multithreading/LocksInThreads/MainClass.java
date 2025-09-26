package Multithreading.LocksInThreads;

public class MainClass {
    public static void main(String[] args) {

        // Shared BankAccount object accessed by multiple threads
        BankAccount bankAccount = new BankAccount();

        //Instead of creating seperate Thread class, here we implemented Runnable interface object.
        // Here it is declared as anonymous class as we cannot create object of interface.
        Runnable task = () -> bankAccount.withdraw(50);

        // Both threads will try to withdraw money at the same time
        // 🔹 With synchronized → Thread-2 must WAIT until Thread-1 finishes (10s delay).
        // 🔹 With tryLock → Thread-2 tries once, fails fast, and moves on without waiting.
        Thread t1 = new Thread(task,"Thread-1");
        Thread t2= new Thread(task,"Thread-2");

        t1.start();
        t2.start();
    }
}
