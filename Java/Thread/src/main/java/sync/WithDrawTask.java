package sync;

public class WithDrawTask implements Runnable {

    private BankAccount account;
    private int amount;

    public WithDrawTask(int amount, BankAccount account) {
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
