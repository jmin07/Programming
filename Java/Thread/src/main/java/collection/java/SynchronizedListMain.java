package collection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {

    public static void main(String[] args) {
        List<String> strings = Collections.synchronizedList(new ArrayList<>());

        strings.add("data");
        strings.add("data2");
        strings.add("data3");
    }
}
