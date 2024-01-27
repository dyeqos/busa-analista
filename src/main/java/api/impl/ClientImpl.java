package api.impl;

import api.dao.ClientRepository;
import api.dao.entity.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientImpl {

    @Inject
    ClientRepository clientRepository;

    public List<Client> listClient(){
        return clientRepository.listAll();
    }
    public Client save(Client client){
        clientRepository.persist(client);
        return client;
    }

    public Client findById(Long clientId){
        return clientRepository.findById(clientId);
    }
}
