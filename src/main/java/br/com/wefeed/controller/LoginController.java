package br.com.wefeed.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wefeed.controller.dto.UserDTO;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping
	public UserDTO login(@RequestBody UserDTO user) {
		return new UserDTO();
	}

}
