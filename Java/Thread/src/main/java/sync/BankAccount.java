package sync;

public interface BankAccount {

    boolean withdraw(int amount); // 계좌의 돈을 출금

    int getBalance();   // 계좌의 잔액을 반환
}
