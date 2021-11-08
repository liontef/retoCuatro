package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.reto3.model.Client;
import com.example.reto3.reto3.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){

        return clientRepository.getAll();

    }

    public Optional<Client> getClient(int id){

        return clientRepository.getClient(id);
    }

    public Client save(Client clt){

        if(clt.getIdClient()==null){

            return clientRepository.save(clt);
        }

        else{

            Optional<Client> cltaux=clientRepository.getClient(clt.getIdClient());
            if(cltaux.isEmpty()){

                return clientRepository.save(clt);
            }
            else{

                return clt;
            }
        }

    }
    
    public Client update(Client clt){
        if(clt.getIdClient()!=null){
            Optional<Client>find= clientRepository.getClient(clt.getIdClient());
            if(!find.isEmpty()){
                if(clt.getEmail()!=null){
                    find.get().setEmail(clt.getEmail());
                }
                if(clt.getPassword()!=null){
                    find.get().setPassword(clt.getPassword());
                }
                if(clt.getName()!=null){
                    find.get().setName(clt.getName());
                }
                if(clt.getAge()!=null){
                    find.get().setAge(clt.getAge());
                }
                return clientRepository.save(find.get());
            }
        }
        return clt;
    }

    public boolean deleteClient(int id){
        Optional<Client> clt=getClient(id);
        if(!clt.isEmpty()){
            clientRepository.delete(clt.get());
            return true;
        }
        return false;
        }
}
