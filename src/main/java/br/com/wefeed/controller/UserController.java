package br.com.wefeed.controller;

import br.com.wefeed.controller.dto.UserDTO;
import br.com.wefeed.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.wefeed.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ResponseEntity<String> validate(@RequestParam String email) {
    	User userByEmail = service.getUserByEmail(email);
    	if (userByEmail != null) {
    		return ResponseEntity.ok("");
    	}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody UserDTO user) {
        service.saveUser(user);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ResponseEntity reset(@RequestBody UserDTO user) {
    	if (user.getEmail() == null || user.getPass() == null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    	}
    	User userByEmail = service.getUserByEmail(user.getEmail());
    	if (userByEmail == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    	}
    	service.resetPassword(userByEmail, user.getPass());
    	
        return ResponseEntity.ok("");
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        boolean remove = service.removeUser(Long.parseLong(id));
        if (remove) {
        	return ResponseEntity.ok("");
        } else {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
    }
}
