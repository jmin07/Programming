package bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    // 특정 시간만큼 대기하도록 설정.
    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data);    // java.lang.IllegalStateException: Queue full
    }

    @Override
    public String take() {
        return queue.remove();  // java.util.NoSuchElementExcetion
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
