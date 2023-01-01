package com.example.demo.op;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MathController {

    @Autowired
    private OpRepository opRepository;
    @RequestMapping(value = "/math", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        ModelAndView mav = new ModelAndView("math");
        mav.addObject("text", frmList(opRepository.findAll()));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value="/math")
    public String doMath(@RequestBody String temp, HttpServletResponse response) {
        //converting data to string
        int num1 = Integer.parseInt(getData(temp, 0));
        int num2 = Integer.parseInt(getData(temp, 1));
        String op = getData(temp, 2);

        //Saving to database
        save(new Operations(num1, num2, op));

        //Redirecting the user to the /math page
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "/math");
        return "redirect:/math";
    }

    private void save(Operations operations) {
        opRepository.save(operations);
        switch (operations.getOperator()) {
            case "add":
                System.out.println("A Számok összege " + (operations.getNum1() + operations.getNum2()));
                break;
            case "sub":
                System.out.println("A Számok különbsége " + (operations.getNum1() - operations.getNum2()));
                break;
            case "mul":
                System.out.println("A Számok szorzata " + (operations.getNum1() * operations.getNum2()));
                break;
            case "div":
                System.out.println("A Számok hányadosa " + (operations.getNum1()) / operations.getNum2());
                break;
        }
    }

    private int getResoult(Operations operations){
        switch (operations.getOperator()) {
            case "add":
                return operations.getNum1() + operations.getNum2();
            case "sub":
                return operations.getNum1() - operations.getNum2();
            case "mul":
                return operations.getNum1() * operations.getNum2();
            case "div":
                return operations.getNum1() / operations.getNum2();
        }
        return 0;
    }
    private String getData(String data, int id) {
        return data.split("&")[id].split("=")[1];
    }

    public String printData(Operations operations) {
        return "A számok: " + operations.getNum1() + " és " + operations.getNum2() + " " + operations.getOperator() + " művelettel" + " eredménye: " + getResoult(operations);
    }

    public String frmList(Iterable<Operations> operations) {
        String list = "";
        for (Operations operation : operations) {
            list += "<div>" + printData(operation) + "</div>";
        }
        return list;
    }
}