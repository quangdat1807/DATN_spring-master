package com.example.datn.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datn.models.ImgProduct;
import com.example.datn.models.Product;
import com.example.datn.repository.ProductImgRepository;
import com.example.datn.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;

@RestController
public class ProductRescontroller {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductImgRepository productImgRepository;

   

  @GetMapping("api/productdetails/{id}")
  public ResponseEntity<Product> getTutorialById(@PathVariable("id") int id, HttpServletRequest request) {
		Optional<Product> tutorialData = productRepository.findById(id);


    HttpSession session = request.getSession();
		if (tutorialData.isPresent()) {
      session.setAttribute("idth", tutorialData.get().getThuonghieu().getIdTH());
      session.setAttribute("idCate", tutorialData.get().getCategory().getCategoryId());
      
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

  


  @GetMapping("api/productimg/{id}")
  public List<ImgProduct> all(@PathVariable("id") Long id){

    return productImgRepository.findByProductId(id);
  }
  

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(value = "/api/products")
    public HashMap<String, Object> insert(@RequestBody @Validated Product product, BindingResult result) {

        HashMap<String, Object> ResponseData = new HashMap<>();
        ResponseData.put("status", true);

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();

            HashMap<String, String> ListValid = new HashMap<>();

            for (FieldError error : fieldErrors) {
                ListValid.put(error.getField(), error.getDefaultMessage());
            }

            ResponseData.put("status", false);
            ResponseData.put("data", ListValid);

            return ResponseData;

        }
        ResponseData.put("data", productRepository.save(product));

        return ResponseData;
    }
  

}
