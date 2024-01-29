package tec.utpl.store.serviceclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.store.serviceclient.entity.Client;
import tec.utpl.store.serviceclient.entity.Region;
import tec.utpl.store.serviceclient.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findClientAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientsByRegion(Region region) {
        return clientRepository.findByRegion(region);
    }

    @Override
    public Client createClient(Client client) {
        Client clientDB = clientRepository.findById(client.getId()).orElse(null);

        if(clientDB !=null){
            return clientDB;
        }

        client.setState("CREATED");
        clientDB = clientRepository.save(client);

        return clientDB;
    }

    @Override
    public Client updateClient(Client client) {
        Client clientDB = clientRepository.findById(client.getId()).orElse(null);

        if(clientDB ==null){
            return null;
        }

        clientDB.setFirstName(client.getFirstName());
        clientDB.setLastName(client.getLastName());
        clientDB.setEmail(client.getEmail());
        clientDB.setPhotoUrl(client.getPhotoUrl());

        return clientRepository.save(clientDB);
    }

    @Override
    public Client deleteClient(Long id) {
        Client clientDB = clientRepository.findById(id).orElse(null);

        if(clientDB==null){
            return null;
        }

        clientRepository.delete(clientDB);

        return clientDB;
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
