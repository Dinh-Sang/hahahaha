package vn.funix.fx21670.java.asm02.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String customerId) {
        super(name, customerId);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    private boolean isPremiumAccount() {
        for(Account account : accounts) {
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        if(!checkedCustomer(newAccount.getAccountNumber())) {
            accounts.add(newAccount);
        }
    }

    // Tổng số dư trong tài khoản
    public double getBalance() {
        double totalBalance = 0;

        for(Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    // Hiển thị thông tin chi tiết của tài khoản
    public void displayInformation() {

        System.out.printf("%12s %8s %6s %11.0f\n", getCustomerId(), getName(), (isPremiumAccount() ? "Premium" : "Normal"), getBalance());
        int number = 1;
        for (Account account : accounts) {
            String accountString = accounts.toString();
            System.out.printf("%1d %10s %28.0f\n", number, accountString);
            number++;
        }
    }

    // Điều kiện kiểm tra STK trong danh sách
    public boolean checkedCustomer(String accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }

        return false;
    }
}
