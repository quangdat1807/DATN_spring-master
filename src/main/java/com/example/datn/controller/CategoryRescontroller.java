package com.example.datn.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.datn.models.Category;
import com.example.datn.repository.CategoryRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CategoryRescontroller {


@Autowired
CategoryRepository categoryRepository;

    
@GetMapping("api/categories")
public List<Category> listCategories(){

    return categoryRepository.findAll();
}


@GetMapping("/api/categories/{id}")
	public Category getById(@PathVariable("id") int id) {
		return categoryRepository.findById(id).orElse(null);
	}


    @PostMapping("/api/categories")
	public Category insert(@RequestBody @Valid Category category) {
		return categoryRepository.save(category);
	}
	
	@PutMapping("/api/categories/{id}")
	public Category update(@PathVariable("id") int id,@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@DeleteMapping("/api/categories/{id}")
	public void delete(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
	}



}
