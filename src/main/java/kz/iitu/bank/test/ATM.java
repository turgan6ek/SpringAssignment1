package kz.iitu.bank.test;

import java.util.Scanner;

public class ATM implements BankService{
    private Double fee;
    private Client client;
    Scanner scan = new Scanner(System.in);
    public ATM(Double fee) {
        this.fee = fee;
    }

    @Override
    public void showMenu(Client client) {
        this.client = client;
        System.out.println("Welcome, " + client.getName());
        System.out.println("Choose what to do: ");
        System.out.println("1.Check Balance \n"
                + "2.Withdraw \n"
                + "3.Top up \n"
                + "4.Check Pin \n"
                + "5.Exit"
        );
        int choice = scan.nextInt();
        int errors = 0;
        String in_pin;
        while (choice != 5 || errors < 3){

            switch (choice) {
                case 1: {
                    System.out.println("Enter the pin please:");
                    in_pin = scan.next();
                    if (in_pin.substring(0,4).equals(this.client.getPin())){
                        System.out.println("Current balance in your account: " + balance());
                    }
                    else {
                        errors++;
                        System.out.println("Incorrect Pin code!!!");
                    }
                }
                break;
                case 2: {

                }
                break;
                case 3: {

                }
                break;
                case 4: {

                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            if (errors >= 3){
                System.out.println("You entered pin incorrectly 3 times");
            }
            System.out.println("1.Check Balance \n"
                                + "2.Withdraw \n"
                                + "3.Top up \n"
                                + "4.Check Pin \n"
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
            this.client.setCash(this.client.getCash() - cash - cash * fee);//Комиссия
            System.out.println("Operation succeed.\n"+
                                    "Available funds in your account: "+ balance());
        }
    }

    @Override
    public void topUp(Integer cash) {
        this.client.setCash(this.client.getCash() + cash - cash * fee);
        System.out.println("Operation succeed.\n"+
                "Available funds in your account: "+ balance());
    }

    @Override
    public void changePin(String pin) {
        this.client.setPin(pin.substring(0,4));
        System.out.println("Your new pin is : " + this.client.getPin());
    }
}
