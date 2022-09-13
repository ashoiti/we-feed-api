package br.com.wefeed.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wefeed.controller.dto.UserDTO;

@RestController
public class AuthController {
	
	@PostMapping(value = "/auth")
	public UserDTO login(@RequestBody UserDTO user) {
		return new UserDTO();
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public UserDTO validate(@RequestParam String email) {
		return new UserDTO();
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
