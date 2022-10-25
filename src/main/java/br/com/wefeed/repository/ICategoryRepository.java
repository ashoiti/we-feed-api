package br.com.wefeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wefeed.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
}
