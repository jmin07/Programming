package collection.simple.list;

import java.util.Arrays;

import static util.ThreadUtils.sleep;

public class BasicList implements SimpleList{

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int size = 0;

    public BasicList() {
        elements = new Object[DEFAULT_CAPACITY]; // 크기 10으로 초기화 (혹은 원하는 크기)
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object object) {
        elements[size] = object;
        sleep(100);
        size++;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}
