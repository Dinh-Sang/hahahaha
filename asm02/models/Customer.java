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

    public void addAccount(Account newAccount) {
        if(!checkedCustomer(newAccount.getAccountNumber())) {
            accounts.add(newAccount);
        } else {
            System.out.println("Số tài khoản đã tồn tại, Không thể thêm tài khoản mới");
        }
    }

    public double getBalance() {
        double totalBalance = 0;

        for(Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        System.out.println(getCustomerId() + getName() + (isPremiumAccount() ? "Premium" : "Normal") + getBalance());
        int number = 1;
        for (Account account : accounts) {
            System.out.println(number + account.getAccountNumber() + getBalance());
        }
    }

    private boolean checkedCustomer(String accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPremiumAccount() {
        for(Account account : accounts) {
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
    }
}
