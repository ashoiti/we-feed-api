package br.com.wefeed.controller.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private String cpf;
	private String name;
	private String login;
	private String pass;
	private String email;
	private String token;
	private String telephone;
	private UserProfile profile;
	private String address;
}
