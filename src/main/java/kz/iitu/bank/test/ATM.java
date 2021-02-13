package kz.iitu.bank.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.Scanner;

public class ATM implements BankService{
    private Client client;
    private Bank bank;
    Connection connection = null;
    Scanner scan = new Scanner(System.in);
    public ATM(Bank bank) {
        this.bank = bank;
    }
    Statement statement = null;

    @Override
    public void showMenu(Client client) {
        this.client = client;
        System.out.println("Welcome, " + client.getName());
        System.out.println("Choose what to do: ");
        System.out.println("1.Check Balance \n"
                + "2.Withdraw \n"
                + "3.Top up \n"
                + "4.Change Pin \n"
                + "5.Exit \n"
        );
        int choice = scan.nextInt();
        int errors = 0;
        String in_pin;
        while (choice != 5 || errors < 3){

            switch (choice) {
                case 1: {
                    System.out.println("Enter the pin please:");
                    in_pin = scan.next();
                    if (in_pin.equals(this.client.getPin())){
                        System.out.println("Current balance in your account: " + balance());
                    }
                    else {
                        errors++;
                        System.out.println("Incorrect Pin code!!!");
                    }
                }
                break;
                case 2: {
                    System.out.println("Enter the pin please:");
                    in_pin = scan.next();
                    if (in_pin.equals(this.client.getPin())){
                        System.out.println("How much do you want to withdraw?");
                        int money = scan.nextInt();
                        withdraw(money);
                    }
                    else {
                        errors++;
                        System.out.println("Incorrect Pin code!!!");
                    }
                }
                break;
                case 3: {
                    System.out.println("Enter the pin please:");
                    in_pin = scan.next();
                    if (in_pin.equals(this.client.getPin())){
                        System.out.println("How much do you want to top up?");
                        int money = scan.nextInt();
                        topUp(money);
                    }
                    else {
                        errors++;
                        System.out.println("Incorrect Pin code!!!");
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter the pin please:");
                    in_pin = scan.next();
                    if (in_pin.equals(this.client.getPin())){
                        System.out.println("Enter new pin please: ");
                        String pin = scan.next();
                        changePin(pin);
                    }
                    else {
                        errors++;
                        System.out.println("Incorrect Pin code!!!");
                    }
                }
                break;
                case 5: {
                    System.out.println("Good bye " + client.getName()+ "!");
                    System.out.println("Please don't forget your card!");
                    return;
                }
                default:
                    System.out.println("Incorrect input!!!");
            }
            if (errors >= 3){
                System.out.println("You entered pin incorrectly 3 times. Your card will be held by ATM. " +
                        "Please contact local customer support.");
                break;
            }
            System.out.println("1.Check Balance \n"
                                + "2.Withdraw \n"
                                + "3.Top up \n"
                                + "4.Change Pin \n"
                                + "5.Exit"
            );
            choice = scan.nextInt();
        }
    }

    @Override
    public Double balance() {
        return this.client.getCash();
    }

    @Override
    public boolean checkPin(String pin) {
        if (this.client.getPin().equals(pin)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void withdraw(Integer cash) {
        if (cash > client.getCash()) {
            System.out.println("Sorry, You don't have enough money.");
            System.out.println("Available funds in your account: " + this.client.getCash());
        }
        else {
            this.client.setCash(this.client.getCash() - cash - cash * this.bank.getFee());//Комиссия
            try {
                Double total = client.getCash() - cash - cash * this.bank.getFee();
                String query = "update accounts set cash = '" + total + "' where client_id = " + client.getClient_id();
                statement = connection.createStatement();
                statement.executeUpdate(query);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("Operation succeed.\n"+
                                    "Available funds in your account: "+ balance());
        }
    }

    @Override
    public void topUp(Integer cash) {
        try {
            Double total = client.getCash() + cash - cash * this.bank.getFee();
            String query = "update accounts set cash = '" + total + "' where client_id = " + client.getClient_id();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
        this.client.setCash(this.client.getCash() + cash - cash * this.bank.getFee());
        System.out.println("Operation succeed.\n"+
                "Available funds in your account: "+ balance());
    }

    @Override
    public void changePin(String pin) {
        try {
            String query = "update accounts set pin = '" + pin + "' where client_id = " + client.getClient_id();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            this.client.setPin(pin);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Your new pin is : " + this.client.getPin());
    }

    @Override
    public void init_method() throws SQLException {
        Connection connection = this.create_DBCon();
        ResultSet set = null;
        String query = "SELECT * FROM accounts";
        statement = connection.createStatement();
        set = statement.executeQuery(query);
        while (set.next()){
            Client client = new Client(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
                    set.getString(5),set.getString(6), set.getString(7), set.getDouble(8));
            bank.getAccounts().add(client);
        }
    }

    @Override
    public Connection create_DBCon() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "madiloh");
            if (connection != null) {
                System.out.println("Connection successfull !!!");
            }
            else {
                System.out.println("Connection failed !!!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void destroy() {
        try {
            connection.close();
            if (connection != null) {
                System.out.println("Connection is closed!!!");
            }
            else {
                System.out.println("Something went wrong!!!");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
