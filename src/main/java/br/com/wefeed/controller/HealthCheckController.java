package br.com.wefeed.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthCheckController {

@GetMapping("/")
public String health() {
  return "UP";
}
}