package api.impl;

import api.dao.ClientRepository;
import api.dao.entity.Client;
import api.data.ClientSearchData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean delete(Client client){
        return clientRepository.deleteById(client.getId());
    }
    public Client search(ClientSearchData searchData){
        Map<String, Object> params = new HashMap<>();
        params.put("documentType", searchData.getDocumentType());
        params.put("documentNumber", searchData.getDocumentNumber());

        return clientRepository.find(
                "SELECT o FROM  Client o WHERE o.documentType=:documentType AND o.documentNumber=:documentNumber",params
        ).firstResult();
    }
    public Client update(Client client){
        Client entity = clientRepository.findById(client.getId());
        entity.setName(client.getName());
        entity.setBirthday(client.getBirthday());
        entity.setFirstLastName(client.getFirstLastName());
        entity.setSecondLastName(client.getSecondLastName());
        entity.setDocumentType(client.getDocumentType());
        entity.setGender(client.getGender());
        entity.setDocumentNumber(client.getDocumentNumber());
        entity.setName(client.getName());

        return client;
    }

    public Client findById(Long clientId){
        return clientRepository.findById(clientId);
    }
}
