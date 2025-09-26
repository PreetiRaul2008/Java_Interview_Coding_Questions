package Multithreading.CreatingThreads;

public class CommomExampleForThreadCreatiom {
 /*  Multitasking: Involves multiple processes running simultaneously.
                    Managed by the operating system.
                    Each process has its own memory space.
                    Achieved through time-sharing and context switching.

     Multithreading:Involves multiple threads within the same process.
                    Threads share the same memory space but have their own stack.
                    More lightweight and faster context switching compared to processes.

     **Key Concepts**
     - Thread: Smallest unit of a process that can execute independently.Shares memory space with other threads in the same process.
     - Process: Independent program with its own memory space.
     - Context Switching: CPU switches between processes or threads, saving and loading state. More overhead with processes than with threads.
     - Threads Share: Heap memory, file descriptors, code segments.
     - Threads Don’t Share: Stack, thread-specific data, CPU registers*/

    public static void main(String[] args) {
        // By calling Thread class
        MyThread t1 = new MyThread();

        // By implementing runnable interface
        MyRunnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);

        //start both the threads
        t1.start();
        t2.start();

    }
}
