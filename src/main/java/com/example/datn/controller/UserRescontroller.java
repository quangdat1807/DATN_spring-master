package com.example.datn.controller;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import com.example.datn.payload.request.ForgotPasswordRequest;
import com.example.datn.payload.request.ResetPassword;
import com.example.datn.service.MailService;
import com.example.datn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.example.datn.payload.response.MessageResponse;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserRescontroller {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;
  
  
    @PostMapping("/account/forgot-password")
      public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest, HttpServletRequest request) {

        String email = forgotPasswordRequest.getEmail();
  
          String response = userService.forgotPassword(email);
  
          if (!response.startsWith("Invalid")) {

            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
              response = url + "/account/reset-password?token=" + response; 

              mailService.sendMailWithResetPassword(email, response);
              
          }else {
            return ResponseEntity.ok(new MessageResponse("fail!"));
          }     
          return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
      }


      
  
      @PutMapping("/account/reset-password")
      public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPassword resetPassword
      ) {

                String password = resetPassword.getPassword();

                String token = resetPassword.getToken();

                userService.resetPassword(token, password);
  
                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
      }


      
    
}
