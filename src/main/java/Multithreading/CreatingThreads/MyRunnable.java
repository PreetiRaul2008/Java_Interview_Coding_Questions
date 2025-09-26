package Multithreading.CreatingThreads;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(char c = 'A'; c < 'E'; c++){
            System.out.println("Letter  : "+ c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
