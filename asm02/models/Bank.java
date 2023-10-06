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

    public Bank(String id, List<Customer> customers) {
        this.id = id;
        this.customers = customers;
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer newCustomer) {
        if(!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        } else {
            System.out.println("Khách hàng cũ, không thể thêm mới");
        }
    }

    private boolean isCustomerExisted(String customerID) {
        for(Customer customer : customers) {
            if(customer.getCustomerId().equals(customerID)) {
                return true;
            }
        }

        return false;
    }
}
