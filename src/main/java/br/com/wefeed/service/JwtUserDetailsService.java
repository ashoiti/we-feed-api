package br.com.wefeed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wefeed.model.User;
import br.com.wefeed.repository.IUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User findByEmail = repository.findByEmail(email);
//		if ("javainuse".equals(username)) {
			return findByEmail;
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
}