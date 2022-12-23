package com.example.demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@Controller
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/math")
	public String welcome() {
		return "temp/index";
	}

	@RequestMapping("doMath")
	public String doMath(@RequestParam String num1, @RequestParam String num2, @RequestParam String op) {
		switch (op) {
			case "add":
				System.out.println("A Számok összege " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
				return "temp/index";
			case "sub":
				System.out.println("A Számok különbsége " + (Integer.parseInt(num1) - Integer.parseInt(num2)));
				return "temp/index";
			case "multiply":
				System.out.println("A Számok szorzata " + (Integer.parseInt(num1) * Integer.parseInt(num2)));
				return "temp/index";
			case "div":
				System.out.println("A Számok hányadosa " + (Integer.parseInt(num1) / Integer.parseInt(num2)));
				return "temp/index";
		}
		return "/math";
	}
}