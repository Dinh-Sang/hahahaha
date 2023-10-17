package vn.funix.fx21670.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.id = String.valueOf(UUID.randomUUID());
        this.customers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Thêm mới khách hàng
    public void addCustomer(Customer newCustomer) {
        if(!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        }
    }

    // Kiểm tra khách hàng đã tồn tại chưa
    public boolean isCustomerExisted(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerID)) {
                return true;
            }
        }

        return false;
    }

    public Customer isCustomerIdExisted(String customerId) {
        for(Customer customer : customers) {
            if(customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }

        return null;
    }
}
