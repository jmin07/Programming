package util;

import static util.MyLogger.*;

public class MyLoggerMain {

    // 같은 패키지에 있는 클래스는 서로 import 없이 사용할 수 있음.
    public static void main(String[] args) {
        log("hello thread");
        log(123);
    }

}
