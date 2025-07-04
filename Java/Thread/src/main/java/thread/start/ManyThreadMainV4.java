package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV4 {

    public static void main(String[] args) {
        log("main() start");

        // 람다 클래스
        Thread thread = new Thread(() -> log("run()"));

        thread.start();

        log("main() end");
    }



}
