package oop.ex.exam02;

public class AccountMain {
    public AccountMain() {
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(2000);
        account.withdraw(1000);
    }
}
