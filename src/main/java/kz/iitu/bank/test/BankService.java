package kz.iitu.bank.test;

public interface BankService {
    void showMenu(Client client);
    Double balance();
    boolean checkPin(Integer pin);
    void withdraw(Integer cash);
    void topUp(Integer cash);
    void changePin(String pin);
}
