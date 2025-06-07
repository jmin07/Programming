package cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockBad {


    /**
     * 스핀 락(Spin Lock)이란?
     * 락이 풀릴 때까지 CPU를 점유한 채로 계속 루프를 돌며(lock이 열릴 때까지) 기다리는 락입니다.
     */

    private volatile boolean locked = false;

    public void lock() {
        log("락 획득 시도");
        while (true) {
            if (!locked) {  // 1. 락 사용 여부 확인
                sleep(100); // 문제 상황 확인용, 스레드 대기
                locked = true;  // 2. 락의 값 변경
                break;
            } else {
                // 락을 획득할 때까지 스핀 대기(바쁜 대기) 한다.
                log("락 획득 실패 - 스핀 대기");
            }
        }
        log("락 획득 완료");
    }

    public void unlock() {
        locked = false; // 원자적인 연산
        log("락 반납 완료");
    }

}
