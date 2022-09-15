package com.example.bankcls;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;



@Component
public class Bank {


    public int balance = 0;

    public String customer_name;
    private int customer_id;

    public Bank() {
    }

    public ExpressionParser getParser() {
        return parser;
    }

    public void setParser(ExpressionParser parser) {
        this.parser = parser;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    ExpressionParser parser = new SpelExpressionParser();
    public void depositCreated() {
        System.out.println(parser.parseExpression(" 'Account Created '").getValue());
        StandardEvaluationContext exp = new StandardEvaluationContext();
        exp.setVariable("name1", this.customer_name);
        System.out.println(parser.parseExpression("'User name '.concat( #name1)").getValue(exp));
        exp.setVariable("balance", this.getBalance());
        System.out.println(parser.parseExpression("'Initial Balance is '.concat( #balance)").getValue(exp));
    }
}
