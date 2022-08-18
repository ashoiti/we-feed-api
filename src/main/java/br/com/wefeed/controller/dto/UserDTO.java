package br.com.wefeed.controller.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String cpf;
	private String name;
	private String login;
	private String pass;
	private String email;

}
