package com.talent.webcalculator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/web-calculator")
class CalculatorController{

    private Integer getResult(Integer op1, Integer op2, String operator) throws InvalidOperationException {

        int result;

        if (operator.equals("add"))
            result = op1 + op2;
        else if (operator.equals("sub"))
            result = op1 - op2;
        else
            throw new InvalidOperationException("Operation not supported!");

        return result;
    }

    @GetMapping(path = "/get")
    public Integer getMapping(@RequestParam Integer op1, @RequestParam Integer op2, @RequestParam String operator) throws InvalidOperationException {
        return getResult(op1, op2, operator);
    }

    @PostMapping(path = "/post")
    public Integer getMapping(@RequestBody CalculatorDTO dto) throws InvalidOperationException{
        return getResult(dto.getOp1(), dto.getOp2(), dto.getOperator());
    }

}