package com.systemsale.systemsale.controller;


import com.systemsale.systemsale.dto.ClientDTO;
import com.systemsale.systemsale.entity.Client;
import com.systemsale.systemsale.service.client.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody Client client) {
        try {
            ClientDTO objClient = clientService.create(client);
            return ResponseEntity.created(new URI("/api/clientes" + objClient.getId())).body(objClient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> read() {
        return ResponseEntity.ok(clientService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id) {
        ClientDTO client = clientService.readById(id);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(client);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Client client) {
        var client1 = this.clientService.readById(id);
        if (client1 == null) return  ResponseEntity.notFound().build();
        client.setId(client1.getId());
        ClientDTO objClient = clientService.update(client);
        return  ResponseEntity.ok(objClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var client = clientService.readById(id);
        if (client == null) return ResponseEntity.notFound().build();
        if(clientService.delete(client.getId())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
