package bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();    // 대기 집합
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    @Override
    public void put(String data) {
        try {
            while (queue.size() == max) {
                log("[put] 큐가 가득, 생산자 대기");
                try {
                    condition.await(); // RUNNABLE -> WAITING, 락 반납
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, notify() 호출");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public BoundedQueueV4(int max) {
        this.max = max;
    }

    @Override
    public String take() {
        try {
            while (queue.isEmpty()) {
                log("[take] 큐에 데이터가 없음, 소비자 대기");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 획득, notify() 호출");
            condition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
