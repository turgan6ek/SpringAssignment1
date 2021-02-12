package kz.iitu.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ClientService employeeService = context.getBean(ClientService.class);
        Bank bank = context.getBean("bank",Bank.class);

        Client emp= new Client();
        employeeService.insertClient(emp);


        employeeService.getAllClients();

//
//        Random rand = new Random();
//        Client randomClient = bank.getAccounts().get(rand.nextInt(bank.getAccounts().size()));
//        bank.getBankService().showMenu(randomClient);
    }
}
