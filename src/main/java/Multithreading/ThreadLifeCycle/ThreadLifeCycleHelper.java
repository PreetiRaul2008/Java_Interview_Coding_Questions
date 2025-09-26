package Multithreading.ThreadLifeCycle;

public class ThreadLifeCycleHelper {
    /*Thread Lifecycle in Java - :
    New – Thread is created but not started yet.
    Runnable – After calling start(), thread is ready to run (waiting for CPU).
    Running – Thread scheduler picks it, and run() executes.
    Waiting/Timed Waiting – Thread waits (either indefinitely with wait(), or with time like sleep()).
    Terminated (Dead) – Thread has finished execution.*/

    public static void main(String[] args) throws InterruptedException {
        //1. NEW State
        MyThreadLifecycle t1 = new MyThreadLifecycle();
        System.out.println("After creating the thread : "+ t1.getState());
        //3.Runnable State
        t1.start();
        System.out.println("After calling start method : "+ t1.getState());

        //small delay to let the thread enter RUNNING
        Thread.sleep(100);
        System.out.println("While the another thread is running : "+ t1.getState());

        //wait untils the thread completes it execution.
        //used when one thread needs to wait for another thread to finish before continuing execution.
        t1.join();
        System.out.println("Thread completion : "+ t1.getState());

    }
}
