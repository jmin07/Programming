package assignment;

import static util.MyLogger.log;

public class AssignmentMain02 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Assignment02(), "counter");
        thread.start();
    }


    static class Assignment02 implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
