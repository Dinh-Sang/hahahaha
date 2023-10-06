package vn.funix.fx21670.java.asm02.models;

public abstract class User {
    private String name;
    private String customerId;

    public User () {

    }

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if(checkCCCD()) {
            this.customerId = customerId;
        } else {
            throw new ArithmeticException("Số CCCD không hợp lệ. Vui lòng nhập lại");
        }
    }

    // Tính hợp lệ CCCD
    private boolean checkCCCD() {
        if (this.customerId.length() != 12) {
            return false;
        }

        for (int i = 0; i < this.customerId.length(); i++) {
            if (!Character.isDigit(this.customerId.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
