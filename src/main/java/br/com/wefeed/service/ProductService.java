package br.com.wefeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wefeed.model.Category;
import br.com.wefeed.model.Product;
import br.com.wefeed.model.User;
import br.com.wefeed.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
	
	@Autowired
	private IProductRepository repository;
	
	public void save(Product product) {
		
		product.setStatus("A");
		repository.save(product);
	}
	
	public void update(Product product) {
		
		repository.save(product);
	}
	
	public List<Product> listByOwner(Integer owner) {
		
		User user = new User();
		user.setId((long)owner);
		
		return repository.findByOwner(user);
	}
	
	public List<Product> listByCategory(Integer idCategory) {
		
		Category category = new Category();
		category.setId((long)idCategory);
		
		return repository.findByCategory(category);
	}
	
	public boolean removeProduct(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}