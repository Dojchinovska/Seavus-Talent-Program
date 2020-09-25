package com.talent.webcalculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CalculatorDTO{

    private Integer op1;

    private Integer op2;

    private String operator;

}