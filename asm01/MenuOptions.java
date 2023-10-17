package vn.funix.fx21670.java.asm01;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MenuOptions {
    private static final Scanner sc = new Scanner(System.in);
    public static final int AUTHCODE_LENGTH = 5;

    public void programFunction() {
        int choice;
        listOptions();

        do {
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 0:
                        System.out.println("Bạn đã thoát khỏi chương trình");
                        return;
                    case 1:
                        addAuthCode();
                        break;
                    default:
                        System.out.println("Yêu cầu không hợp lệ. Vui lòng thử lại");
                        System.out.print("Chức năng: ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Yêu cầu không hợp lệ. Vui lòng thử lại!");
                System.out.print("Chức năng: ");
            }
        } while (choice != 0);
    }

    // Menu chương trình
    public static void listOptions() {
        System.out.println("+----------+--------------------------+");
        System.out.println("| 1. Nhập CCCD                        |");
        System.out.println("| 0. Thoát                            |");
        System.out.println("+----------+--------------------------+");
        System.out.print("Chức năng: ");
    }

    // Random mã xác thực
    private static String createAuthcode() {
        Random random = new Random();
        int easyCode = random.nextInt(900) + 100;
        return String.valueOf(easyCode);
    }

    // Kiểm tra mã xác thực
    private void addAuthCode() {
        String importCode;
        String authCode = createAuthcode();
        System.out.println("Mã xác thực: " + authCode);

        while (true) {
            System.out.print("Nhập mã xác thực: ");
            importCode = sc.nextLine();

            if (importCode.equals("0")) {
                System.out.println("Bạn đã thoát khỏi chương trình");
                System.exit(0);
            }

            if (authCode.equals(importCode)) {
                Validator validator = new Validator();
                validator.managerCCCD();
                break;
            } else {
                System.out.println("Mã xác thực không đúng. Vui lòng thử lại");
                System.out.println("");
                System.out.println("Mã xác thực: " + authCode);
                System.out.println("Chọn 0 để thoát khỏi chương trình");
            }
        }
    }
}

