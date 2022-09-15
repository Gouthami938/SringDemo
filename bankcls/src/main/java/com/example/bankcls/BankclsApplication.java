package com.example.bankcls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BankclsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =SpringApplication.run(BankclsApplication.class, args);

		Bank obj =context.getBean(Bank.class);
		Deposite obj1 = context.getBean(Deposite.class);
		Withdraw obj2 = context.getBean(Withdraw.class);
		interest obj3=context.getBean(interest.class);
		obj.setCustomer_id(1023);
		obj.setCustomer_name("Gouthami");
		obj.depositCreated();
			obj1.depositMoney(5000);
			obj2.withdraw(1000);
			obj3.getInterest();

	}

}
