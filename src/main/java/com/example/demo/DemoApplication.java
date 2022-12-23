package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/api/addup")
	@ResponseBody
	public String getFood(@RequestParam String num1, @RequestParam String num2){
		return "A két szám összege " + (Integer.parseInt(num1) + Integer.parseInt(num2)) ;
	}
}
