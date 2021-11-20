package com.example.datn.service;

import com.example.datn.models.Customer;
import com.example.datn.repository.CustomerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
	CustomerSession customerSession;

	


    @Autowired
	CustomerRepository customerRepository;

    @Override
	public Customer getCustomer() {
		return customerSession.getCustomer();
	}

    @Override
	public boolean isCustomerLogin() {
		return customerSession.getCustomer() != null;
	}


	

    @Override
	public boolean getUser(Long userId) {
		Customer customer = customerRepository.findByUserId(userId);
		if(customer != null) {
			customerSession.setCustomer(customer);
			return true;
		}
		return false;
	}


	
}
