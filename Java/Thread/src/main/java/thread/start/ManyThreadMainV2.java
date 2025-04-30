package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV2 {

    public static void main(String[] args) {
        log("main() start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        log("main() end");
    }


    // 외부 클래스와 독립적
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }

    }
}
