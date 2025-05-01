package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    // entry point
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(4000);
        log("stop Mytask Thread.interrupt()");
        thread.interrupt();
        log("thread.isInterrupted(): " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("working");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("Thread.currentTHread().isInterrupted(): " + Thread.currentThread().isInterrupted());
                log("interrupt meassage: " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("thread terminated");
        }
    }

}
