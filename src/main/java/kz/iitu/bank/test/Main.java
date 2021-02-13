package kz.iitu.bank.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BankService bankService = context.getBean("bankService1", ATM.class);
        Random rand = new Random();

        Client randomClient = bankService.getBank().getAccounts().get(rand.nextInt(bankService.getBank().getAccounts().size()));
        bankService.showMenu(randomClient);
        ((ClassPathXmlApplicationContext) context).close();
    }
}
