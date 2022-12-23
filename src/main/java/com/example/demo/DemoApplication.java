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
	@GetMapping("/api/math/add")
	@ResponseBody
	public String getNumForAdding(@RequestParam String num1, @RequestParam String num2){
		return "A két szám összege " + (Integer.parseInt(num1) + Integer.parseInt(num2)) ;
	}
	@GetMapping("/api/math/subtracts")
	@ResponseBody
	public String getNumForSubtracting(@RequestParam String num1, @RequestParam String num2){
		return "A két szám különbsége " + (Integer.parseInt(num1) - Integer.parseInt(num2)) ;
	}
	@GetMapping("/api/math/multiply")
	@ResponseBody
	public String getNumForMultiplying(@RequestParam String num1, @RequestParam String num2){
		return "A két szám szorzata " + (Integer.parseInt(num1) * Integer.parseInt(num2)) ;
	}
	@GetMapping("/api/math/divide")
	@ResponseBody
	public String getNumForDividing(@RequestParam String num1, @RequestParam String num2){
		return "A Számok hányadosa " + (Integer.parseInt(num1) / Integer.parseInt(num2)) ;
	}
}
