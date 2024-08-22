package com.springboot.study.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;

@Entity
@Table(name = "customer")

public class Customer {

    @Id
    @Column(name="customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String CustomerName;

    @Column(name = "customer_address",length = 255)
    private String CustomerAddress;

    @Column(name = "customer_salary",length = 100)
    private String CustomerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1 ")
    private boolean activeState;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, String customerSalary, String nic, boolean activeState) {
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
        return "Customer{" +
                "customerId=" + customerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", CustomerSalary='" + CustomerSalary + '\'' +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
