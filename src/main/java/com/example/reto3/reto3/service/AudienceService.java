package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reto3.reto3.model.Audience;
import com.example.reto3.reto3.repository.AudienceRepository;


@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){

        return audienceRepository.getAll();

    }

    public Optional<Audience> getAudience(int id){

        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audi){

        if(audi.getId()==null){

            return audienceRepository.save(audi);
        }

        else{

            Optional<Audience> audiaux=audienceRepository.getAudience(audi.getId());
            if(audiaux.isEmpty()){

                return audienceRepository.save(audi);
            }
            else{

                return audi;
            }
        }

    }

    public Audience update(Audience audi){
        if(audi.getId()!=null){
            Optional<Audience>find= audienceRepository.getAudience(audi.getId());
            if(!find.isEmpty()){
                if(audi.getName()!=null){
                    find.get().setName(audi.getName());
                }
                if(audi.getOwner()!=null){
                    find.get().setOwner(audi.getOwner());
                }
                if(audi.getCapacity()!=null){
                    find.get().setCapacity(audi.getCapacity());
                }
                if(audi.getDescription()!=null){
                    find.get().setDescription(audi.getDescription());
                }
                return audienceRepository.save(find.get());
            }
        }
        return audi;
    }

    public boolean deleteAudience(int id){
        Optional<Audience> audi=getAudience(id);
        if(!audi.isEmpty()){
            audienceRepository.delete(audi.get());
            return true;
        }
        return false;
        }

    
}

