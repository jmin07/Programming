package lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        ParkTest parkTest = new ParkTest();

        Thread thread = new Thread(parkTest, "parkTest");
        thread.start();

        sleep(100);
        log("thread state: " + thread.getState());
        log("main -> unpark(parkTest)");
//        LockSupport.unpark(thread);

        thread.interrupt(); // thread state is runnable and isInterrupted is ture
    }


    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
