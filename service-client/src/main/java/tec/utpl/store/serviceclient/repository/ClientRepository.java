package tec.utpl.store.serviceclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.store.serviceclient.entity.Client;
import tec.utpl.store.serviceclient.entity.Region;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    // public Customer findByNumberID(String numberId);
    public List<Client> findByLastName(String lastName);
    public List<Client> findByRegion(Region region);
}
