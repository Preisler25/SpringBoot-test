package com.example.demo.op;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @Autowired
    private OpRepository opRepository;
    @RequestMapping("/math")
    public String welcome() {
        return "temp/index";
    }

    @RequestMapping(method = RequestMethod.POST, value="/math")
    public void doMath(@RequestBody String temp) {
        String[] arrOfStr = temp.split("&", 3);
        int num1 = Integer.parseInt(arrOfStr[0].split("=")[1]);
        int num2 = Integer.parseInt(arrOfStr[1].split("=")[1]);
        String op = arrOfStr[2].split("=")[1];
        switch (op) {
            case "add":
                System.out.println("A Számok összege " + (num1 + num2));
                opRepository.save(new Operations(num1, num2, op));
                break;
            case "sub":
                System.out.println("A Számok különbsége " + (num1 - num2));
                opRepository.save(new Operations(num1, num2, op));
                break;
            case "mul":
                System.out.println("A Számok szorzata " + (num1 * num2));
                opRepository.save(new Operations(num1, num2, op));
                break;
            case "div":
                System.out.println("A Számok hányadosa " + (num1) / num2);
                opRepository.save(new Operations(num1, num2, op));
                break;
        }
    }
}
