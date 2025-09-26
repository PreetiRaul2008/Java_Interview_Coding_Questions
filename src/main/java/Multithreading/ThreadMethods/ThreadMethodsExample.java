package Multithreading.ThreadMethods;

public class ThreadMethodsExample {

    public static void main(String[] args) throws InterruptedException {
        // currentThread(): Main thread reference
        System.out.println("Current Thread: " + Thread.currentThread().getName());

        // Create two User threads
        ThreadMethodHelper t1 = new ThreadMethodHelper("User-Thread-1");
        ThreadMethodHelper t2 = new ThreadMethodHelper("User-Thread-2");

        // setPriority(): Defines importance of a thread (1 to 10)
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        // setDaemon(true): Marks thread as daemon (background)
        // Daemon threads stop automatically when all user threads finish
        t2.setDaemon(true);

        // start(): Creates new thread and calls run() internally
        t1.start();
        t2.start();

        // isAlive(): Returns true if thread is still running
        System.out.println(t1.getName() + " is alive? " + t1.isAlive());

        // join(): Makes main thread wait until t1 completes
        t1.join();
        System.out.println(t1.getName() + " completed. Now main continues...");

        // interrupt(): Requests thread to stop (sets interrupted flag)
        // If thread is sleeping, causes InterruptedException
        t2.interrupt();

        System.out.println("Main thread finished.");
    }
}
