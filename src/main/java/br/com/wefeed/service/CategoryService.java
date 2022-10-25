package br.com.wefeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wefeed.controller.dto.UserDTO;
import br.com.wefeed.controller.dto.UserProfile;
import br.com.wefeed.model.Category;
import br.com.wefeed.model.User;
import br.com.wefeed.repository.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {
	
	@Autowired
	private ICategoryRepository repository;
	
	public List<Category> getCategories() {
	
		return repository.findAll();

	}

}