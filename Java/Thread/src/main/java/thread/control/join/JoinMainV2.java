package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV2 {

    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread2");

        thread1.start();
        thread2.start();

        // 정확한 타이밍을 맞추어 기다리기 어려움
        log("main thread sleep()");
        sleep(3000);
        log("main thread WakeUp");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumALl = task1.result + task2.result;
        log("sumALl = " + sumALl);

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
