package cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("atomicInteger = " + atomicInteger);

//        int result1 = atomicInteger.getAndIncrement();
//        System.out.println("result = " + result1);
//
//        int result2 = atomicInteger.getAndIncrement();
//        System.out.println("result = " + result2);


         // incrementAndGet 구현
        int result = incrementAndGet(atomicInteger);
        System.out.println("result = " + result);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get(); // 해당 구간에서 다른
            log("getValue: " + getValue);

            // 현재 값이 getValue와 같다면, 그 값을 getValue + 1로 원자적으로 바꿔라는 뜻입니다.
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result: " + result);

        } while (!result);


        do {
            getValue = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(getValue, getValue + 1));

        return 0;
    }
}
