package br.com.wefeed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.wefeed.model.Product;
import br.com.wefeed.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/findByOwner", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findByOwner(@RequestParam String owner) {
    	List<Product> listByOwner = service.listByOwner(Integer.parseInt(owner));
        return ResponseEntity.status(HttpStatus.OK).body(listByOwner);
    }
    
    @RequestMapping(value = "/findByCategory", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findByCategory(@RequestParam String category) {
    	List<Product> listByCategory = service.listByCategory(Integer.parseInt(category));
        return ResponseEntity.status(HttpStatus.OK).body(listByCategory);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody Product product) {
        service.save(product);
        return ResponseEntity.ok("");
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Product product) {
    	if (product.getId() == null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID required");
    	}
        service.save(product);
        return ResponseEntity.ok("");
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        service.removeProduct(Long.parseLong(id));
        return ResponseEntity.ok("");
    }

}
