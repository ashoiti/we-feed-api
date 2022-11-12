package br.com.wefeed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wefeed.model.Category;
import br.com.wefeed.model.Product;
import br.com.wefeed.model.User;

public interface IProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByOwner(User owner);
	
	List<Product> findByCategory(Category category);
}
