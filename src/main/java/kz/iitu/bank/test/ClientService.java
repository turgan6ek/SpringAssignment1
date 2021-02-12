package kz.iitu.bank.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService implements ClientServiceInterface{

    @Autowired
    ClientDao clientDao;

    @Override
    public void insertClient(Client client) {
        clientDao.insertClient(client);
    }

    @Override
    public void insertClients(List<Client> clients) {
        clientDao.insertClients(clients);
    }

    @Override
    public void getAllClients() {
        clientDao.getAllClients();
    }

    @Override
    public void getClientById(String client_id) {
        clientDao.getClientById(client_id);
    }
}
