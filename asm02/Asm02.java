package vn.funix.fx21670.java.asm02;

import vn.funix.fx21670.java.asm02.models.Bank;

import java.util.Scanner;

public class Asm02 {
    private static final String AUTHOR = "FX21670";
    private static final String VERSION = "V1.0.0";

    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        System.out.println("+----------+--------------------------+");
        System.out.println("| NGÂN HÀNG SỐ |" + AUTHOR + "-" + VERSION + "        |");
        System.out.println("+----------+--------------------------+");
        System.out.println("1. Them khach hang");
        System.out.println("2. Them tai khoan cho khach hang");
        System.out.println("3. Hien thi danh sach khach hang");
        System.out.println("4. Tim theo ten khach hang");
        System.out.println("5. Tim theo CCCD");
        System.out.println("6. Thoat");
        System.out.println("+----------+--------------------------+");
        System.out.print("Chuc nang: ");

        System.out.println(bank);
    }
}
