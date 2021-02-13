package kz.iitu.bank.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> accounts;
    private Double fee;
    public Bank() { }
     public Bank(List<Client> accounts, Double fee) {
        this.accounts = accounts;
        this.fee = fee;
    }

    public List<Client> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Client> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Client client){
        this.accounts.add(client);
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
