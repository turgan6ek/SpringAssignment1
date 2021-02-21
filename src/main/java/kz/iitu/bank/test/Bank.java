package kz.iitu.bank.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Bank {
    @Autowired
    private List<Client> accounts;

    private Double fee = 0.02;
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
