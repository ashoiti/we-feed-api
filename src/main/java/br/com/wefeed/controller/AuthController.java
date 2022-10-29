package br.com.wefeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wefeed.controller.dto.UserDTO;
import br.com.wefeed.model.User;
import br.com.wefeed.service.UserService;

@CrossOrigin
@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService service;
	
	@PostMapping(value = "/auth")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO user) {
		
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPass()));
		User userAuth = (User)authenticate.getPrincipal();
		
		UserDTO ret = service.getUserDTO(userAuth);
		ret.setToken(service.getUserToken(userAuth));
		
		return ResponseEntity.ok(ret);
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ResponseEntity<String> validate(@RequestParam String email) {
		return ResponseEntity.ok("");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public UserDTO create(@RequestBody UserDTO user) {
		return new UserDTO();
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public UserDTO reset(@RequestBody UserDTO user) {
		return new UserDTO();
	}
	
	

}
