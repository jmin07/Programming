package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "mythread");
        thread.start();

        sleep(1000);

        myTask.flag = false;
        log("flag = " + myTask.flag + ", count = " + myTask.count + " in main");
    }


    static class MyTask implements Runnable {

        volatile boolean flag = true;
        long count;

        // main 캐시 메모리 (974321305) -> 메인 메모리 -> MyTask 캐시 메모리 (1000000000)
        @Override
        public void run() {
            while(flag) {
                count++;

                // 1억 번에 한 번씩 출력
                if (count % 100000000 == 0) {
                    log("flag = " + flag + ", count = " + count);
                }
            }
            log("flag = " + flag + ", count = " + count + " end");
        }
    }
}
