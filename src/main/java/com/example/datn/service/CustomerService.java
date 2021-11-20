package com.example.datn.service;

import com.example.datn.models.Customer;

public interface CustomerService {
    Customer getCustomer();
    boolean isCustomerLogin();
    boolean getUser(Long uesrId);

   
}
