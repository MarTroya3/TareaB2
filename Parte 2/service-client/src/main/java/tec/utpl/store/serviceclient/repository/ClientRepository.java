package tec.utpl.store.serviceclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.sotre.servicecustomer.entity.Client;
import tec.utpl.sotre.servicecustomer.entity.Region;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    // public Client findByNumberID(String numberId);
    public List<Client> findByLastName(String lastName);
    public List<Client> findByRegion(Region region);
}
