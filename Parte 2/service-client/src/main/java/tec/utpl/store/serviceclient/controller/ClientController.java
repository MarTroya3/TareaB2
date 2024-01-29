package tec.utpl.store.serviceclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.store.serviceclient.entity.Client;
import tec.utpl.store.serviceclient.entity.Region;
import tec.utpl.store.serviceclient.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listAllClients(@RequestParam(name = "region", required = false) Long regionId){
        List<Client> clients = new ArrayList<>();
        if (regionId == null){
            clients = clientService.findClientAll();

            if(client.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        Region region = new Region();
        region.setId(regionId);
        clients = clientService.findClientsByRegion(region);

        if(clients.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clients);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id){
        Client client = clientService.getClient(id);

        if(null == client){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Customer clientCreated = clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client){
        Client clientDB = clientService.getClient(id);

        if(null==clientDB){
            return ResponseEntity.notFound().build();
        }

        customer.setId(id);

        clientDB = clientService.updateClient(client);

        return ResponseEntity.ok(clientDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        Client clientDB = clientService.getClient(id);

        if(null==clientDB){
            return ResponseEntity.notFound().build();
        }

        clientDB = clientService.deleteClient(id);

        return ResponseEntity.ok("Cliente eliminado");
    }

}
