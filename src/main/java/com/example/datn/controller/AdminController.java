package com.example.datn.controller;

import java.util.List;

import com.example.datn.models.MessageNotifications;
import com.example.datn.models.Role;
import com.example.datn.payload.response.JwtResponse;
import com.example.datn.repository.MessageNotificationsRepository;
import com.example.datn.security.services.UserDetailsImpl;
import com.example.datn.service.CustomerService;
import com.example.datn.service.UserService;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {



    @Autowired
    UserService userService;


    @Autowired
    CustomerService customerService;


    @GetMapping("admin/product")
    public String listProduct(Model model){
      
        //  if (userService.isRole()) {
        //     return "dashboard/products";
        //  }

        // model.addAttribute("username",customerService.getCustomer().getUser().getUsername());
         return "dashboard/products"; 
    }
    

    @GetMapping("admin/category")
    public String listCategory(){
      
        //  if (userService.isRole()) {
        //     return "dashboard/products";
        //  }
         return "dashboard/categories"; 
    }


    @GetMapping("admin/customer")
    public String listCustomer(){
      
        //  if (userService.isRole()) {
        //     return "dashboard/products";
        //  }
         return "dashboard/khachhang"; 
    }


    @GetMapping("admin/user")
    public String listUser(){
      
        //  if (userService.isRole()) {
        //     return "dashboard/products";
        //  }
         return "dashboard/user"; 
    }
    
//    @GetMapping("admin/report")
//    public String drawChart() {
//    	return "dashboard/thongke";
//    }


    @Autowired
    MessageNotificationsRepository messageNotificationsRepository;

    @GetMapping("admin/order")
    public String listOrder(Model model){
      
        //  if (userService.isRole()) {
        //     return "dashboard/products";
        //  }

        List<MessageNotifications> ntn = messageNotificationsRepository.findAll();

        model.addAttribute("noti", ntn);
         return "dashboard/order"; 
    }
}
