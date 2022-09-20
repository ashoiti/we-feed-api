package br.com.wefeed.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wefeed.repository.IUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		br.com.wefeed.model.User findByEmail = repository.findByEmail(email);
//		if ("javainuse".equals(username)) {
			return new User(findByEmail.getName(), findByEmail.getPassword(),
					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
}