package com.example.bankcls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class Withdraw {
@Autowired
    private Bank b1;

    ExpressionParser parser = new SpelExpressionParser();

    public void withdraw ( int amount) {
       // if (b1.customerid == customernum) {
            if (b1.balance > amount) {
                b1.setBalance(b1.balance - amount);
                System.out.println(parser.parseExpression(" 'withdrawn method'").getValue());
                StandardEvaluationContext ecbalance = new StandardEvaluationContext();
                ecbalance.setVariable("balance", b1.getBalance());
                System.out.println(parser.parseExpression("'Balance after withdraw : '.concat( #balance)").getValue(ecbalance));
                //System.out.println("Your Current balance "+this.getBalance());
            } else {
                System.out.println(parser.parseExpression(" 'Insufficient balance '").getValue());
            }
        }
    }

