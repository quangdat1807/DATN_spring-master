package com.example.datn.service;


import java.math.BigDecimal;
import java.util.Map;

import com.example.datn.models.GioHang;
import com.example.datn.models.Product;


public interface CartService {
    public GioHang getGioHang();
	public void themSanPham(int productId);
	public void truSanPham(int productId);
	public void xoaSanPham(int productId);

	

	BigDecimal getTotal();
	


	
}
