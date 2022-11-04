package br.com.wefeed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wefeed.model.Category;
import br.com.wefeed.model.User;
import br.com.wefeed.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> categories() {
		
//		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return ResponseEntity.ok(service.getCategories());
	}
	
}
