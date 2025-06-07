package cas.increment;

public class SyncInteger implements IncrementInteger{

    // 임계 영역 안에서 안전하게 수행
    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int get() {
        return value;
    }

}
