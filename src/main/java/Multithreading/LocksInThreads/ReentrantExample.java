package Multithreading.LocksInThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    // Create a ReentrantLock instance.
    // A ReentrantLock allows the same thread to acquire the lock multiple times
    // without causing itself to get stuck (deadlock).

    private final Lock lock = new ReentrantLock();

    /**
     * outerMethod acquires the lock, does some work, and calls innerMethod.
     * Since the same thread is already holding the lock, calling innerMethod
     * (which also tries to acquire the lock) will still succeed.
     * This is what makes it a "reentrant" lock.
     */
    public void outerMethod(){
        lock.lock(); // Acquire the lock
        try{
            System.out.println("Outer Method");
            // Call another method that also tries to acquire the same lock
            innerMethod();
        }finally {
            // Always release the lock in a finally block to avoid deadlocks
            lock.unlock();
        }
    }
    /**
     * innerMethod also acquires the lock.
     * Because ReentrantLock is reentrant, the same thread
     * can acquire the lock again without waiting.
     */
    public void innerMethod(){
        lock.lock(); // Same thread can lock again without blocking
        try{
            System.out.println("Inner Method");
        }finally {
            lock.unlock(); // Release the lock once
        }
    }

    /** NOTE:
     * When a thread calls lock.lock() the first time, the hold count is set to 1 and the thread becomes the owner of the lock.
     * If the same thread calls lock.lock() again (re-enters), the hold count increases to 2, 3, and so on.
     * The lock is not released until the thread calls unlock() the same number of times it called lock().
     * Each unlock() reduces the count by 1.
     **/
    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();
    }
}
