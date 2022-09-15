package com.example.bankcls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class interest {
    @Autowired
    private Bank b2;
    ExpressionParser parser = new SpelExpressionParser();
    public void getInterest () {
        StandardEvaluationContext evloutioncontext = new StandardEvaluationContext();
        evloutioncontext.setVariable("interestAmount", (0.05 * b2.balance));
        System.out.println(parser.parseExpression(" 'Interest rate = 5%'").getValue());
        System.out.println(parser.parseExpression("'Interest Calculated = '.concat( #interestAmount)").getValue(evloutioncontext));
    }
}
