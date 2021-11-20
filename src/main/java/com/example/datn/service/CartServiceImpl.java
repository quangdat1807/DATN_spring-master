package com.example.datn.service;

import java.math.BigDecimal;


import com.example.datn.models.GioHang;
import com.example.datn.models.Product;
import com.example.datn.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
	
	@Autowired
	private GioHang gioHang;
	
	public GioHang getGioHang() {
		return gioHang;
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public void themSanPham(int productId) {
		Product product = productRepository.findById(productId).get();
		if (gioHang.getChiTietGioHang().containsKey(product)) {
			int count = gioHang.getChiTietGioHang().get(product);
			gioHang.getChiTietGioHang().replace(product, count + 1);
		} else {
			gioHang.getChiTietGioHang().put(product, 1);
		}
	}
	
	
	@Override
	public void truSanPham(int productId) {
		Product product = productRepository.findById(productId).get();
		if (gioHang.getChiTietGioHang().containsKey(product)) {
			int count = gioHang.getChiTietGioHang().get(product);
			gioHang.getChiTietGioHang().replace(product, count - 1);
		}
	}
	
	@Override
	public void xoaSanPham(int productId) {
		Product product = productRepository.findById(productId).get();
		if (gioHang.getChiTietGioHang().containsKey(product)) {
			gioHang.getChiTietGioHang().remove(product);
		}
	}



	@Override
    public BigDecimal getTotal() {
        return gioHang.getChiTietGioHang().entrySet().stream()
                .map(entry -> entry.getKey().getGia().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

	

	

	
}