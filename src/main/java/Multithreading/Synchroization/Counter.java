package Multithreading.Synchroization;

/**
 * Counter Example - Demonstrating Race Condition and Critical Section
 * ------------------------------------------------------------------
 * Problem:
 *   Multiple threads are incrementing a shared variable (count).
 *   Because 'count++' is not atomic, threads interfere with each other
 *   and final output becomes inconsistent (less than expected).
 *
 * What is this problem called?
 * --> This is called a RACE CONDITION.
 *
 * What is a Critical Section?
 * -->  A critical section (or critical area) is the part of code where
 *      shared resources (like variables, files, DB records) are accessed
 *      or modified. Here, 'count++' is the critical section.
 *
 * Solution:
 *   Protect the critical section using 'synchronized' or atomic classes.
 */
public class Counter {

    private int count = 0; // Shared resource (accessed by multiple threads)

    // Increment method WITHOUT synchronization
    // Critical section: 'count++' is not thread-safe
    // Increment method WITH synchronization
    // Only one thread can execute this method at a time
    public synchronized void increment(){
        count ++;
    }

    public int getCount(){
        return count;
    }
}


