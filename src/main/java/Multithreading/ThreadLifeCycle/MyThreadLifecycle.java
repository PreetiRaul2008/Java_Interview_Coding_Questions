package Multithreading.ThreadLifeCycle;

public class MyThreadLifecycle extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running ... State : "+ getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread execution completed :  " + getState());
    }
}
