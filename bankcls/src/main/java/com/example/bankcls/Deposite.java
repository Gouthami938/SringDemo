package com.example.bankcls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class Deposite {

    @Autowired
    private Bank b;
    ExpressionParser parser = new SpelExpressionParser();

    public void depositCreated() {
        System.out.println(parser.parseExpression(" 'Account Created '").getValue());
        StandardEvaluationContext exp = new StandardEvaluationContext();
        exp.setVariable("name1", b.customer_name);
        System.out.println(parser.parseExpression("'User name '.concat( #name1)").getValue(exp));
        exp.setVariable("balance", b.getBalance());
        System.out.println(parser.parseExpression("'Initial Balance is '.concat( #balance)").getValue(exp));
    }
    public void depositMoney(int amount) {
      //  if (this.customerid == customernum) {
            b.setBalance(b.balance + amount);
            System.out.println(parser.parseExpression("'Deposit Method'").getValue());
            StandardEvaluationContext ecbalance = new StandardEvaluationContext();
            ecbalance.setVariable("balance", b.getBalance());
            System.out.println(parser.parseExpression("'Balance after deposite : '.concat( #balance)").getValue(ecbalance));
        }
    }


