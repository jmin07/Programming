package cas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CasMainV3 {

    /**
     * 스레드가 충돌할 때마다 반복해서 다시 시도하므로, 결과적으로 락 없이 데이터를 안전하게 변경할 수 있다.
     * 충돌이 드물게 발생하는 환경에서는 락을 사용하지 않으므로 높은 성능을 발휘할 수 있다.
     *
     * 단, 자주 실패하고 재시도해야 하는 경우, 성능 저하가 발생할 수 있다.
     *
     * 락(Lock) 방식
     *  - 비관적 접근 방법
     *  - 데이터에 접근하기전에 항상 락을 획득
     *  - 다른 스레드의 접근을 막음
     *  - "다른 스레드가 방해할 것이다." 라고 가정
     *
     *  CAS 방식
     *   - 낙관적 접근법
     *   - 락을 사용하지 않고 데이터에 바로 접근
     *   - 충돌이 발생하면 그 때 재시도
     *   - "대부분의 경우 충돌이 없을 것이다" 라고 가정
     */

    public static int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("atomicInteger = " + atomicInteger);


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        // System.out.println("i = " + result);


    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get(); // 해당 구간에서 다른
            sleep(100);
            log("getValue: " + getValue);

            // 현재 값이 getValue와 같다면, 그 값을 getValue + 1로 원자적으로 바꿔라는 뜻입니다.
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result: " + result);

        } while (!result);


        return getValue + 1;
    }
}
