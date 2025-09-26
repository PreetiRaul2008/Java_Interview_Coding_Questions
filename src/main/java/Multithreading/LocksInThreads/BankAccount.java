package Multithreading.LocksInThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    /**
     * Withdraws the given amount from the account.
     * Instead of synchronized, we use tryLock().
     * <p>
     * 🔹 If we had used 'synchronized' here:
     * - Once Thread-1 enters withdraw() and sleeps for 10 seconds,
     * Thread-2 would be forced to WAIT the entire 10 seconds,
     * even if it just wanted to check the balance.
     * <p>
     * 🔹 With ReentrantLock + tryLock():
     * - Thread-2 tries to acquire the lock.
     * - If the lock is already taken by Thread-1, it immediately fails
     * and prints a message like "could not acquire lock".
     * - This prevents Thread-2 from getting stuck waiting unnecessarily.
     */

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        // Non-blocking attempt to acquire the lock
        if (lock.tryLock()) {
            try {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " processing payment...");
                    try {
                        // Simulate a long operation (e.g., contacting server, processing transaction)
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdrawal successful. Available balance: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance!");
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            } finally {
                // Always release the lock to avoid deadlocks
                lock.unlock();
            }
        } else {
            // If lock is not available, thread skips instead of waiting
            System.out.println(Thread.currentThread().getName() + " could not acquire lock, will try again later.");
        }
    }
}

