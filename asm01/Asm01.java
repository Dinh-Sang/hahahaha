package vn.funix.fx21670.java.asm01;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Asm01 {
    private static Scanner sc = new Scanner(System.in);
    private static final String AUTHOR = "FX21670";
    private static final String VERSION = "V1.0.0";

    public static void main(String[] args) {
        System.out.println("+----------+--------------------------+");
        System.out.println("| NGÂN HÀNG SỐ |" + AUTHOR + "-" + VERSION + "        |");

        MenuOptions menuOptions = new MenuOptions();
        menuOptions.programFunction();
    }
}


