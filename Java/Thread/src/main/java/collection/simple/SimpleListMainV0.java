package collection.simple;

import java.util.ArrayList;

public class SimpleListMainV0 {

    // 대부분의 연산은 원자적인 연산이 아니다. thread safe 하지 않다.

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 스레드1, 스레드2가 동시에 실행 가정
        list.add("A"); // thread 1
        list.add("B"); // thread 2


        System.out.println(list);
    }
}
