package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);

        Thread thread1 = new Thread(task1, "thread-1");
        thread1.start();

        try {
            /*
                join() 의 단점은 다른 스레드가 완료될 때까지 무기한 기다리는 단점이 있다.
                만약 다른 스레드의 작업을 일정 시간 동안만 기다리고 싶다면 어떻게 해야할까? => join()
             */
            log("main thread waiting 1000 ms");
            thread1.join(1000);
            log("main thread waited");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log("task1.result = " + task1.result);
        log("End");
    }

    /*
        인스턴스의 메서드를 호출하면, 어떤 인스턴스의 메서드를 호출했는지 기억하기 위해,
        해당 인스턴스의 참조값을 스택 프레임 내에 저장해둔다.
     */
    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;

        SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("thread start");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("thread end result = " + result);
        }
    }
}
