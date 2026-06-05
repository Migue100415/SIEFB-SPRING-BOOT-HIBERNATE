package com.SIEFB.SIEFB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SiefbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiefbApplication.class, args);
	}
	
	@GetMapping("/api/personas")
    public String hello(@RequestParam(value = "SIEFB", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

}
