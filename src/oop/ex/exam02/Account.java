package oop.ex.exam02;

public class Account {
    int balance = 10000;

    public Account() {
    }

    void deposit(int amount) {
        this.balance += amount;
        System.out.println("" + amount + "원을 입급하였습니다. 현재 잔액 >> " + this.balance);
    }

    void withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("" + amount + "원을 출금하였습니다. 현재 잔액 >> " + this.balance);
        } else {
            System.out.println("잔고가 부족합니다.");
        }

    }

}
