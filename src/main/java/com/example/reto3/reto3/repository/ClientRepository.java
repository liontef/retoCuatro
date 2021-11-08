package com.example.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto3.reto3.model.Client;
import com.example.reto3.reto3.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){

        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){

        return clientCrudRepository.findById(id);

    }

    public Client save(Client clt){

        return clientCrudRepository.save(clt);
    }

    public void delete(Client clt){
        clientCrudRepository.delete(clt);
    }
    
}

