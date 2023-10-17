package vn.funix.fx21670.java.asm01;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Validator {
    private static Scanner sc = new Scanner(System.in);
    public static final int CCCD_LENGTH = 12; // Kiểm tra độ dài cccd
    private String cccd;
    private static final Map<String, String> provinceMap = createProvinceMap();

    public void addCCCD() {
        cccd = sc.nextLine();
    }

    public void managerCCCD() {
        while (true) {
            System.out.print("Nhập số CCCD:");
            addCCCD();

            if (cccd.equals("0")) {
                System.out.println("Bạn đã thoát khỏi chương trình");
                System.exit(0);
            }

            if (isCCCD()) {
                chooseCCCD();
                break;
            } else {
                System.out.println("CCCD không đúng. Vui lòng nhập lại");
                System.out.println("Chọn 0 để thoát khỏi chương trình");
            }
        }
    }

    public void chooseCCCD() {
        while (true) {
                System.out.println("1. Kiểm tra nơi sinh");
                System.out.println("2. Kiểm tra năm sinh, giới tính");
                System.out.println("3. Kiểm tra số ngẫu nhiên");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                Integer choose = sc.nextInt();

            try {
                if (choose.equals(1)) {
                    isValidProvince(cccd);
                } else if (choose.equals(2)) {
                    isValidBirthGender();
                } else if (choose.equals(3)) {
                    isValidRandom();
                } else if (choose.equals(0)) {
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    System.exit(0);
                } else {
                    System.out.println("Yêu cầu không đúng. Vui lòng thực hiện lại yêu cầu");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Yêu cầu không đúng. Vui lòng thực hiện lại yêu cầu!");
            }
        }
    }

    public boolean isCCCD() {
        if (cccd.length() != CCCD_LENGTH) {
            return false;
        }

        for (int i = 0; i < cccd.length(); i++) {
            if (!Character.isDigit(cccd.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // Số ngẫu nhiên
    private void isValidRandom() {
        String randomCCCD = cccd.substring(6, 11);
        System.out.println("Số ngẫu nhiên: " + randomCCCD);
    }


    // Kiểm tra năm sinh, giới tính
    private void isValidBirthGender() {
        char genderCode = cccd.charAt(3);
        String century = cccd.substring(4, 6);

        if (genderCode == '0' || genderCode == '1') {
            switch (genderCode) {
                case '0':
                    System.out.println("Giới tính: Nam" + " | " + "Năm sinh: 19" + century);
                    break;
                case '1':
                    System.out.println("Giới tính: Nữ" + " | " + "Năm sinh: 19" + century);
                    break;
                default:
                    System.out.println("Unknown");
            }
        } else if (genderCode == '2' || genderCode == '3') {
            switch (genderCode) {
                case '2':
                    System.out.println("Giới tính: Nam" + " | " + "Năm sinh: 20" + century);
                    break;
                case '3':
                    System.out.println("Giới tính: Nữ" + " | " + "Năm sinh: 20" + century);
                    break;
                default:
                    System.out.println("Unknown");
            }
        } else if (genderCode == '4' || genderCode == '5') {
            switch (genderCode) {
                case '4':
                    System.out.println("Giới tính: Nam" + " | " + "Năm sinh: 21" + century);
                    break;
                case '5':
                    System.out.println("Giới tính: Nữ" + " | " + "Năm sinh: 21" + century);
                    break;
                default:
                    System.out.println("Unknown");
            }
        } else if (genderCode == '6' || genderCode == '7') {
            switch (genderCode) {
                case '6':
                    System.out.println("Giới tính: Nam" + " | " + "Năm sinh: 22" + century);
                    break;
                case '7':
                    System.out.println("Giới tính: Nữ" + " | " + "Năm sinh: 22" + century);
                    break;
                default:
                    System.out.println("Unknown");
            }
        } else if (genderCode == '8' || genderCode == '9') {
            switch (genderCode) {
                case '2':
                    System.out.println("Giới tính: Nam" + " | " + "Năm sinh: 23" + century);
                    break;
                case '3':
                    System.out.println("Giới tính: Nữ" + " | " + "Năm sinh: 23" + century);
                    break;
                default:
                    System.out.println("Unknown");
            }
        }
    }

    // Kiểm tra tính phù hợp của cccd theo mã tỉnh thành trong package asm02
    public static boolean validProvinceCode(String provinceCode) {
        return provinceMap.containsKey(provinceCode);
    }

    // Kiểm tra nơi sinh
    public boolean isValidProvince(String provinceCode) {
        provinceCode = cccd.substring(0, 3);
        int provinceCodeInt = Integer.parseInt(provinceCode);
        if (1 <= provinceCodeInt && provinceCodeInt <= 96) {
            provinceCode = getProvinceName(provinceCode);
            System.out.println(provinceCode);
            return true;
        }

        return false;
    }

    public String getProvinceName(String provinceCode) {
        return provinceMap.getOrDefault(provinceCode, "Unknown");
    }

    private static Map<String, String> createProvinceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("001", "Hà Nội");
        map.put("002", "Hà Giang");
        map.put("004", "Cao Bằng");
        map.put("006", "Bắc Kạn");
        map.put("008", "Tuyên Quang");
        map.put("010", "Lào Cai");
        map.put("011", "Điện Biên");
        map.put("012", "Lai Châu");
        map.put("014", "Sơn La");
        map.put("015", "Yên Bái");
        map.put("017", "Hòa Bình");
        map.put("019", "Thái Nguyên");
        map.put("020", "Lạng Sơn");
        map.put("022", "Quảng Ninh");
        map.put("024", "Bắc Giang");
        map.put("025", "Phú Thọ");
        map.put("026", "Vĩnh Phúc");
        map.put("027", "Bắc Ninh");
        map.put("030", "Hải Dương");
        map.put("031", "Hải Phòng");
        map.put("033", "Hưng Yên");
        map.put("034", "Thái Bình");
        map.put("035", "Hà Nam");
        map.put("036", "Nam Định");
        map.put("037", "Ninh Bình");
        map.put("038", "Thanh Hóa");
        map.put("040", "Nghệ An");
        map.put("042", "Hà Tĩnh");
        map.put("044", "Quảng Bình");
        map.put("045", "Quảng Trị");
        map.put("046", "Thừa Thiên Huế");
        map.put("048", "Đà Nẵng");
        map.put("049", "Quảng Nam");
        map.put("051", "Quảng Ngãi");
        map.put("052", "Bình Định");
        map.put("054", "Phú Yên");
        map.put("056", "Khánh Hòa");
        map.put("058", "Ninh Thuận");
        map.put("060", "Bình Thuận");
        map.put("062", "Kon Tum");
        map.put("064", "Gia Lai");
        map.put("066", "Đắk Lắk");
        map.put("067", "Đắk Nông");
        map.put("068", "Lâm Đồng");
        map.put("070", "Bình Phước");
        map.put("072", "Tây Ninh");
        map.put("074", "Bình Dương");
        map.put("075", "Đồng Nai");
        map.put("077", "Bà Rịa - Vũng Tàu");
        map.put("079", "Hồ Chí Minh");
        map.put("080", "Long An");
        map.put("082", "Tiền Giang");
        map.put("083", "Bến Tre");
        map.put("084", "Trà Vinh");
        map.put("086", "Vĩnh Long");
        map.put("087", "Đồng Tháp");
        map.put("089", "An Giang");
        map.put("091", "Kiên Giang");
        map.put("092", "Cần Thơ");
        map.put("093", "Hậu Giang");
        map.put("094", "Sóc Trăng");
        map.put("095", "Bạc Liêu");
        map.put("096", "Cà Mau");
        return map;
    }

}

