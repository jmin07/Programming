package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    // entry point
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(100);
        log("stop Thread.interrupt()");
        thread.interrupt();
        log("thread.isInterrupted(): " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            while (!Thread.interrupted()) {    // 인터럽트 상태 변경 O
                log("working");
            }
            // 예외 처리에서는 false 로 나온다.
            // 인터럽트 예외가 한 번 발생하고 목적을 당성하면 인터럽트의 상태를 다시 돌려야한다.
            log("Thread.currentThread().isInterrupted(): " + Thread.currentThread().isInterrupted());   // false
        }
    }

}
