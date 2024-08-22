package com.springboot.study.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class CustomerDTO {
    private int customerId;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerSalary;
    private String nic;
    private boolean activeState;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, String customerSalary, String nic, boolean activeState) {
        this.customerId = customerId;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
        CustomerSalary = customerSalary;
        this.nic = nic;
        this.activeState = activeState;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerSalary() {
        return CustomerSalary;
    }

    public void setCustomerSalary(String customerSalary) {
        CustomerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", CustomerSalary='" + CustomerSalary + '\'' +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
