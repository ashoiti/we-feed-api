package br.com.wefeed.controller.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.wefeed.model.Category;
import br.com.wefeed.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO{

    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Category category;
    private User owner;
    private String status;
    private LocalDate dueDate;

}