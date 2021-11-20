package com.example.datn.intenceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.datn.models.GioHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GioHangInterceptor implements HandlerInterceptor {
	

	@Autowired
	private GioHang gioHang;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
	throws Exception {
		// nếu giỏ hàng trống thì chuyển về trang chủ
		if (gioHang.getChiTietGioHang().size() == 0) {
			
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
