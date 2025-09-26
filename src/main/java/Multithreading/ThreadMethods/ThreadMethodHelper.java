package Multithreading.ThreadMethods;

public class ThreadMethodHelper extends Thread {
    ThreadMethodHelper(String name){
        super(name); //setName(): Assigns a custom thread name
    }

    @Override
    // run(): Entry point of a thread (executed when start() is called)

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started. Priority: " + getPriority());
        for(int i = 0; i < 5; i++){
            // Check if thread was interrupted
            if(Thread.currentThread().isInterrupted()){
                // currentThread(): Returns reference of currently executing thread
                System.out.println(Thread.currentThread().getName()+" is Interrupted");
                return;
            }
            System.out.println(getName() + " → Count: " + i);

            if(i == 2){
                // yield(): Suggests thread scheduler to give CPU to other threads
                System.out.println(getName() + " yielding...");
                Thread.yield();
            }
            try {
                // sleep(): Temporarily pauses the thread for given time (ms)
                // Puts thread into TIMED_WAITING state
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // yield(): Suggests thread scheduler to give CPU to other threads
                System.out.println(getName() + " yielding...");System.out.println(getName() + " interrupted during sleep.");
                return;
            }
        }
    }
}
