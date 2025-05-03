package sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) {

        BankAccountV6 account = new BankAccountV6(1000);

        Thread thread01 = new Thread(new WithDrawTask(800, account), "t1");
        Thread thread02 = new Thread(new WithDrawTask(800, account), "t2");

        thread01.start();
        thread02.start();

        sleep(500);
        log("thread01 state: " + thread01.getState());
        log("thread02 state: " + thread02.getState());

        try {
            thread01.join();
            thread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log("최종 잔액: " + account.getBalance());
    }

}
