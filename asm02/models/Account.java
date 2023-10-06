package vn.funix.fx21670.java.asm02.models;

public class Account {
    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Kiểm tra loại Premium
    public boolean isPremiumAccount() {
        return balance >= 10_000_000;
    }

    @Override
    public String toString() {
        return accountNumber + balance;
    }
}
