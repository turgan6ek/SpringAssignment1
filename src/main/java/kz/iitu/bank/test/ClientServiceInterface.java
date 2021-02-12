package kz.iitu.bank.test;

import java.util.List;

public interface ClientServiceInterface {
    void insertClient(Client client);
    void insertClients(List<Client> clients);
    void getAllClients();
    void getClientById(String client_id);
}
