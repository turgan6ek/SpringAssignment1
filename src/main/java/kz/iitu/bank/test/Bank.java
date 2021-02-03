package kz.iitu.bank.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> accounts;
    private BankService bankService;
    public Bank() { }
     public Bank(List<Client> accounts, BankService bankService) {
        this.accounts = accounts;
        this.bankService = bankService;
    }

    public List<Client> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Client> accounts) {
        this.accounts = accounts;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

}
