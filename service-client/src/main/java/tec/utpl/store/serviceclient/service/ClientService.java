package tec.utpl.store.serviceclient.service;

import tec.utpl.store.serviceclient.entity.Client;
import tec.utpl.store.serviceclient.entity.Region;

import java.util.List;

public interface ClientService {
    public List<Client> findCustomerAll();
    public List<Client> findCustomersByRegion(Region region);

    public Client createClient();
    public Client updateClient (Client client);
    public Client deleteClient(Long id);
    public Client getClient(Long id);
}
