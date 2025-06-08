package collection.simple.list;

import static util.MyLogger.log;

public class SimpleListMainV2 {


    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
//        test(new SyncList());

        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList lists) throws InterruptedException {
        log(lists.getClass().getSimpleName());

        Runnable runA = new Runnable() {
            @Override
            public void run() {
                lists.add("A");
                log("Thread-2: list.add(A)");
            }
        };

        Runnable runB = new Runnable() {
            @Override
            public void run() {
                lists.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread threadA = new Thread(runA);
        Thread threadB = new Thread(runB);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        log(lists.toString());
    }
}
