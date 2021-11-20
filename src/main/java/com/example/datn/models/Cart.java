package com.example.datn.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cart {
    private Map<Product, Integer> cartDetails = new HashMap<Product, Integer>();

	public Map<Product, Integer> getCartDetails() {
		return cartDetails;
	}

	public void setChiTietGioHang(Map<Product, Integer> cartDetails) {
		this.cartDetails = cartDetails;
	}
}
