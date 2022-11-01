package br.com.wefeed.service;

import br.com.wefeed.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wefeed.config.JwtTokenUtil;
import br.com.wefeed.controller.dto.UserDTO;
import br.com.wefeed.controller.dto.UserProfile;
import br.com.wefeed.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private IUserRepository repository;
	
	public String getUserToken(User user) {
	
		String token = null;
		try {
			token = jwtTokenUtil.generateToken(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		
		return token;
	}
	
	public UserDTO getUserDTO(User user) {
		
		UserDTO ret = new UserDTO();
		ret.setCpf(user.getCpf());
		ret.setEmail(user.getEmail());
		ret.setName(user.getName());
		ret.setProfile(UserProfile.valueOf(user.getProfile()));
		
		return ret;
	}

	public User saveUser (UserDTO dto) {

		User dtoUser = new User();

		dtoUser.setCpf(dto.getCpf());
		dtoUser.setName(dto.getName());
		dtoUser.setEmail(dto.getEmail());
		dtoUser.setTelephone(dto.getTelephone());
		dtoUser.setProfile(dto.getProfile().toString());
		dtoUser.setPassword(dto.getPass());

		return repository.save(dtoUser);
	}
}
