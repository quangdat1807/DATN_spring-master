package com.example.datn.controller;


import com.example.datn.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CartController {


    @Autowired
    CartService cartService;

	

	@GetMapping("cart/gio-hang")
	public String gioHang(Model model) {
		model.addAttribute("cart", cartService.getGioHang());
		model.addAttribute("total", cartService.getTotal().toString());

		return "cart";
		
	}
    
    @GetMapping("cart/them-vao-gio/{idSanPham}")
	public String addGioHang(@PathVariable("idSanPham") int idSanPham) {
        cartService.themSanPham(idSanPham);
		return "redirect:/cart/gio-hang";
	}
	
	
	@GetMapping("cart/tru-san-pham/{idSanPham}")
	public String truSanPham(@PathVariable("idSanPham") int idSanPham) {
        cartService.truSanPham(idSanPham);
		return "redirect:/cart/gio-hang";
	}
	
	@GetMapping("cart/xoa-san-pham/{idSanPham}")
	public String xoaSanPham(@PathVariable("idSanPham") int idSanPham) {
        cartService.xoaSanPham(idSanPham);
		return "redirect:/cart/gio-hang";
	}



	@GetMapping("cart")
	public String  cart(Model model) {
		model.addAttribute("cart", cartService.getGioHang());
		model.addAttribute("total", cartService.getTotal().toString());

		return "giohang";
		
	}


	@GetMapping("cart/add/{idSanPham}")
	public String addCart(@PathVariable("idSanPham") int idSanPham) {
        cartService.themSanPham(idSanPham);
		return "redirect:/cart";
	}
	
	
	@GetMapping("cart/minus/{idSanPham}")
	public String minusCart(@PathVariable("idSanPham") int idSanPham) {
        cartService.truSanPham(idSanPham);
		return "redirect:/cart";
	}
	
	@GetMapping("cart/remove/{idSanPham}")
	public String removeCart(@PathVariable("idSanPham") int idSanPham) {
        cartService.xoaSanPham(idSanPham);
		return "redirect:/cart";
	}
}
