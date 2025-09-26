package Multithreading.CreatingThreads;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Numbers : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
