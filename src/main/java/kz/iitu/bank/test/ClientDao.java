package kz.iitu.bank.test;

import java.util.List;

public interface ClientDao {
    void insertClient(Client cl);
    void insertClients(List<Client> clients);
    List<Client> getAllClients();
    Client getClientById(String empId);
}
