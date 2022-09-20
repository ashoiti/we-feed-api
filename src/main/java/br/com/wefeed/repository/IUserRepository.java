package br.com.wefeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wefeed.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
