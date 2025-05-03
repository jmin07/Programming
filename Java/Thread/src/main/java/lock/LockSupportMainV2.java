package lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        ParkTest parkTest = new ParkTest();

        Thread thread = new Thread(parkTest, "parkTest");
        thread.start();

        sleep(100);
        log("thread state: " + thread.getState());
    }


    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2000_000000);
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
