package cas.increment;

public class VolatileInteger implements IncrementInteger {

    // volatile 를 적용해도 해결은 안됨.
    volatile private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
