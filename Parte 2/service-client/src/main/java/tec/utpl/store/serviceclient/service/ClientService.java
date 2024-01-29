package tec.utpl.store.serviceclient.service;

import tec.utpl.store.serviceclient.entity.Client;
import tec.utpl.store.serviceclient.entity.Region;

import java.util.List;

public interface ClientService {
    public List<Client> findClientAll();
    public List<Client> findClientsByRegion(Region region);

    public Client createClient(Client client);
    public Client updateClient (Client client);
    public Client deleteClient (Long id);
    public Client getClient(Long id);
}
