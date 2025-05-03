package sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance;    // volatile 적용해도 해결이 안됨.

    public BankAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
        if (balance < amount) {
            log("[검증 실패]");
            return false;
        }

        // 잔고가 출금액 보다 많으면, 진행
        sleep(1000); // 출금에 걸리는 시간
        log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
        balance = balance - amount;
        log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        log("거래 종료");
        return true;
    }
}
