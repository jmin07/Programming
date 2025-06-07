package cas.spinlock;

import static util.MyLogger.log;

public class SpinLockMain {

    // 숫자 값의 증가, 자료 구조의 데이터 추가와 같이 cpu 사이클이 금방 끝나는 연산에 사용해야 효과적이다.

    public static void main(String[] args) {
        // SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    // critical section
                    log("비즈니스 로직 실행");
                    // 오래 걸리는 비즈니스 로직은 스레드가 cpu를 계속 사용해서 대기하는 것으로 안 좋다.
                    // BLOCKED, WAITING 상태의 스레드는 CPU를 거의 사용하지 않는다.
                } finally {
                    spinLock.unlock();
                }

            }
        };

        /**
         * 똑같은 객체를 스레드가 동시에 실행시킨다.
         * thread01과 thread02 가 동시에 실행된다.
         * 임계영역이 보호가 안 되었다.
         *
         * synchronized 또는 Lock 을 사용해서 두 코드를 동기화해야한다.
         */

        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);

        thread01.start();
        thread02.start();

    }
}
