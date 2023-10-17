package vn.funix.fx21670.java.asm02;


import vn.funix.fx21670.java.asm02.models.Account;
import vn.funix.fx21670.java.asm02.models.Bank;
import vn.funix.fx21670.java.asm02.models.Customer;
import vn.funix.fx21670.java.asm02.models.User;

import java.util.List;
import java.util.Scanner;

public class Asm02 {
    private static final String AUTHOR = "FX21670";
    private static final String VERSION = "V1.0.0";

    private static final Bank bank = new Bank();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("+----------+--------------------------+");
        System.out.println("| NGÂN HÀNG SỐ |" + AUTHOR + "-" + VERSION + "        |");
        System.out.println("+----------+--------------------------+");

        boolean function = true;
        while (function) {
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Thêm tài khoản cho khách hàng");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Tìm theo CCCD");
            System.out.println("5. Tìm theo tên khách hàng");
            System.out.println("0. Thoát");
            System.out.println("+----------+--------------------------+");
            System.out.print("Chuc nang: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addAccountCustomer();
                    break;
                case 3:
                    displayCustomer();
                    break;
                case 4:
                    findIdCustomer();
                    break;
                case 5:
                    findNameCustomer();
                    break;
                case 0:
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    function = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
            System.out.println("+----------+--------------------------+");
        }
    }

    // Thêm khách hàng (1)
    private static void addCustomer() {
        System.out.print("Nhập tên khách hàng: ");
        String name = sc.nextLine().toUpperCase();
        sc.nextLine();
        System.out.print("Nhập số CCCD: ");
        String customerId = sc.nextLine();
        Customer customer = bank.isCustomerIdExisted(customerId);

        if (customer != null) {
            System.out.println("Khách hàng đã tồn tại trong hệ thống");
        } else {
            User user = new User(name, customerId);
            user.setName(name);
            while (true) {
                try {
                    user.setCustomerId(customerId);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát");
                    System.out.print("Nhập số CCCD: ");
                    customerId = sc.nextLine();
                    if (customerId.equalsIgnoreCase("no")) {
                        System.out.println("Bạn đã thoát khỏi chương trình");
                        System.exit(0);
                    }
                }
            }

            Customer newCustomer = new Customer(name, customerId);
            bank.addCustomer(newCustomer);
            System.out.println("Đã thêm khách hàng " + name + customerId + " vào danh sách");
        }
    }

    // Thêm tài khoản cho khách hàng (2)
    private static void addAccountCustomer() {
        sc.nextLine();
        System.out.print("Nhập CCCD khách hàng: ");
        String customerId = sc.nextLine();
        Customer customer = bank.isCustomerIdExisted(customerId);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng với CCCD đã nhập.");
            return;
        }

        String accountNumber;
        while (true) {
            System.out.print("Nhập mã STK gồm 6 chữ số: ");
            accountNumber = sc.nextLine();
            if (accountNumber.length() != 6) {
                System.out.println("Mã STK gồm 6 chữ số. Vui lòng nhập lại");
            } else if (customer.checkedCustomer(accountNumber)) {
                System.out.println("STK tồn tại. Vui lòng nhập lại");
            } else {
                break;
            }
        }

        double balance;
        while (true) {
            System.out.print("Nhập số dư: ");
            balance = sc.nextDouble();
            if (balance >= 50_000) {
                break;
            } else {
                System.out.println("Số dư tài khoản không được nhỏ hơn 50_000VNĐ");
            }
        }
        Account newAccount = new Account(accountNumber, balance);
        customer.addAccount(newAccount);
    }

    // Hiển thị danh sách khách hàng (3)
    private static void displayCustomer() {
        List<Customer> customers = bank.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào");
        } else {
            for (Customer customer : customers) {
                customer.displayInformation();
            }
        }
    }

    // Tìm theo CCCD khách hàng (4)
    private static void findIdCustomer() {
        sc.nextLine();
        System.out.print("Nhập CCCD: ");
        String customerId = sc.nextLine();
        Customer customer = bank.isCustomerIdExisted(customerId);
        if (customer == null) {
            System.out.println("Không có khách hàng trong danh sách");
        } else {
            customer.displayInformation();
        }
    }

    // Tìm theo tên khách hàng (5)
    private static void findNameCustomer() {
        System.out.print("Nhập tên khách hàng: ");
        sc.nextLine();
        String name = sc.nextLine().toUpperCase();
        List<Customer> customers = bank.getCustomers();

        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                customer.displayInformation();
            }
        }
    }
}
