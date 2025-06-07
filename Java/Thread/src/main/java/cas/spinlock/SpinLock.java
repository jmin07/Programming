package cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static util.MyLogger.log;

public class SpinLock {

    /**
     * 락 획득할 때 중요한 부분은 두 연산을 하나로 만들어야 한다.
     * 1. 락 사용 여부 확인
     * 2. 락의 값 변경
     *
     *
     * CAS를 사용해서 원자적인 연산을 만든 덕분에 무거운 동기화 작업 없이 가벼운 락을 만들 수 있다.
     *
     * 동기화 락을 사용하는 경우, 스레드가 획득하지 못하면 BLOCKED, WAITING 등으로 상태가 변한다.
     * 그리고 대기 상태의 스레드를 깨워야 하는 과정이 추가로 들어간다.
     */

    private final AtomicBoolean locked = new AtomicBoolean(false);

    public void lock() {
        log("락 획득 시도");
        while(!locked.compareAndSet(false, true)) {
            // 락을 획득할 때까지 스핀 대기(바쁜 대기) 한다.
            log("락 획득 실패 - 스핀 대기");
        }
        log("락 획득 완료");
    }

    public void unlock() {
        locked.set(false);
        log("락 반납 완료");
    }
}
