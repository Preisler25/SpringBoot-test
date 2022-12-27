package com.example.demo.op;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MathController {

    @Autowired
    private OpRepository opRepository;
    @RequestMapping("/math")
    public String welcome() {
        return "temp/index";
    }

    @RequestMapping("doMath")
    public String doMath(@RequestParam String num1, @RequestParam String num2, @RequestParam String op) {

        switch (op) {
            case "add":
                System.out.println("A Számok összege " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
                opRepository.save(new Operations(Integer.parseInt(num1), Integer.parseInt(num2), "add"));
                return "temp/index";
            case "sub":
                System.out.println("A Számok különbsége " + (Integer.parseInt(num1) - Integer.parseInt(num2)));
                opRepository.save(new Operations(Integer.parseInt(num1), Integer.parseInt(num2), "sub"));
                return "temp/index";
            case "mul":
                System.out.println("A Számok szorzata " + (Integer.parseInt(num1) * Integer.parseInt(num2)));
                opRepository.save(new Operations(Integer.parseInt(num1), Integer.parseInt(num2), "mul"));
                return "temp/index";
            case "div":
                System.out.println("A Számok hányadosa " + (Integer.parseInt(num1) / Integer.parseInt(num2)));
                opRepository.save(new Operations(Integer.parseInt(num1), Integer.parseInt(num2), "div"));
                return "temp/index";
        }
        return "/math";
    }
}
