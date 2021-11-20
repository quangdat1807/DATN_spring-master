package com.example.datn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Transactional
@Controller
public class ReportController {
	@Autowired
	SessionFactory factory;
	Date toDate = new Date(System.currentTimeMillis());
	SimpleDateFormat fomatTime2 = new SimpleDateFormat("yyyy-dd-MM");
	String date2 = fomatTime2.format(toDate.getTime());
	String month = date2.substring(date2.indexOf("-") + 4, date2.length());
	SimpleDateFormat fomatTime = new SimpleDateFormat("yyyy-MM-dd");
	String date = fomatTime.format(toDate.getTime());
	String year = date.substring(0, date.indexOf("-"));

	//report
	@RequestMapping("admin/report")
	public String thongke(ModelMap model, HttpServletRequest request) {

		return "/dashboard/thongke";
	}

}
