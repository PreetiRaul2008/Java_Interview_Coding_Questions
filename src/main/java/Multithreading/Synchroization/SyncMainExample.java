package Multithreading.Synchroization;

public class SyncMainExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        // join() ensures main thread waits for both threads to finish
        t1.join();
        t2.join();

        // Expected result = 20000 (10000 + 10000)
        // Actual result without synchronization = less than 20000 (Race Condition)
        // Actual result with synchronization = always 20000
        System.out.println(counter.getCount());
    }
}
