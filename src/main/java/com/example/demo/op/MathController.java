package com.example.demo.op;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


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

    private void save(Operations operations) {opRepository.save(operations);}

    private String printData(Operations operations){
        switch (operations.getOperator()) {
            case "add":
                return "A Számok összege " + (operations.getNum1() + operations.getNum2());
            case "sub":
                return "A Számok különbsége " + (operations.getNum1() - operations.getNum2());
            case "mul":
                return "A Számok szorzata " + (operations.getNum1() * operations.getNum2());
            case "div":
                return "A Számok hányadosa " + (operations.getNum1() / operations.getNum2());
        }
        return "0";
    }
    private String getData(String data, int id) {return data.split("&")[id].split("=")[1];}

    public String frmList(Iterable<Operations> operations) {
        String list = "";
        List<Operations> opList = new ArrayList<>();
        operations.forEach(opList::add);

        for (int i = opList.size()-1; i >= 0; i--) {
            list += "<div>" + printData(opList.get(i)) + "</div>";
        }
        return list;
    }
}