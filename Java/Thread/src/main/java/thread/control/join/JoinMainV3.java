package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV3 {

    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread2");

        thread1.start();
        thread2.start();

        try {
            /*
                join() 의 단점은 다른 스레드가 완료될 때까지 무기한 기다리는 단점이 있다.
                만약 다른 스레드의 작업을 일정 시간 동안만 기다리고 싶다면 어떻게 해야할까?
             */
            log("main thread wanting start");
            thread1.join();
            thread2.join();
            log("main thread waited");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
