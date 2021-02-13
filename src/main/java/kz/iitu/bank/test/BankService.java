package kz.iitu.bank.test;

import java.sql.Connection;
import java.sql.SQLException;

public interface BankService {
    void showMenu(Client client);
    Double balance();
    boolean checkPin(String pin);
    void withdraw(Integer cash);
    void topUp(Integer cash);
    void changePin(String pin);
    void init_method() throws SQLException;
    Connection create_DBCon();
    Bank getBank();
    void setBank(Bank bank);
    void destroy() throws SQLException;
}
