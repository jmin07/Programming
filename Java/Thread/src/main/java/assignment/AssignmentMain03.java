package assignment;

import static util.MyLogger.log;

public class AssignmentMain03 {
    public static void main(String[] args) {
        RunnableA runnableA = new RunnableA("A", 1000);
        RunnableA runnableB = new RunnableA("B", 500);

        Thread threadA = new Thread(runnableA, "runnableA");
        Thread threadB = new Thread(runnableB, "runnableB");

        threadA.start();
        threadB.start();
    }

    static class RunnableA implements Runnable {
        private String name;
        private int time;

        RunnableA(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(time);
                    log("value : " + name);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
