package com.example.lab3.controller.api;

import com.example.lab3.dto.ClientDto;
import com.example.lab3.model.Client;
import com.example.lab3.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clients", produces = {"application/json", "application/xml"})
public class ClientController {

    final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Integer id){
        return clientRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Client client){
        clientRepository.saveAndFlush(client);
    }

    @PostMapping("/create")
    public Client create(@RequestBody ClientDto clientDto){
        Client client = new Client(clientDto.getName(), clientDto.getCity(), clientDto.getEmail());
        clientRepository.saveAndFlush(client);
        return client;
    }

    @DeleteMapping("/delete/{id}")
    public Client delete(@PathVariable Integer id){
        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
        return client;
    }
}