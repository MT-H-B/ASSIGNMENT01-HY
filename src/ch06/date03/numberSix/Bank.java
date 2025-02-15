package ch06.date03.numberSix;

public class Bank {

    String name;
    int balance;

    public Bank(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    long withdrawal(long amount) {
        if (amount > balance) {
            System.out.println("잔액부족으로 출금할 수 없습니다.");
            return 0;
        }

        balance -= amount;
        return amount;
    }

    void deposit(long amount) {
        balance += amount;
    }
}
