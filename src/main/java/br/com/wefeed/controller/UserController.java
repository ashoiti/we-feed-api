package br.com.wefeed.controller;

import br.com.wefeed.controller.dto.UserDTO;
import br.com.wefeed.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.wefeed.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ResponseEntity<String> validate(@RequestParam String email) {
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody UserDTO user) {
        User userCreate = service.saveUser(user);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public UserDTO reset(@RequestBody UserDTO user) {
        return new UserDTO();
    }
}
