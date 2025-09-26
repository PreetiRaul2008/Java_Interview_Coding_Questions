package Multithreading.Synchroization;

public class MyThread extends Thread{
    Counter counter;

    MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for( int i = 0 ; i < 10000 ; i++){
            counter.increment();
        }
    }
}
