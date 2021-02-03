package kz.iitu.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Bank bank = context.getBean("bank",Bank.class);
        //There are 5 clients in the bank.
        //And I just chose the random client when starting the application.
        //The pin codes are in 'beans.xml' file.

        Random rand = new Random();
        Client randomClient = bank.getAccounts().get(rand.nextInt(bank.getAccounts().size()));
        bank.getBankService().showMenu(randomClient);
    }
}
