package com.talent.webcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class CalculatorController {

    @RequestMapping(path = "webcalculator", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    private Integer getResult(@RequestParam Integer op1, @RequestParam Integer op2, @RequestParam String operator) {

        switch (operator) {
            case "add":
                return op1 + op2;
            case "sub":
                return op1 - op2;
        }
        throw new IllegalArgumentException("Invalid operator");
    }
}