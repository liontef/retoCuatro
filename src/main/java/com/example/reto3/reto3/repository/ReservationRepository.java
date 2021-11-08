package com.example.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto3.reto3.model.Reservation;
import com.example.reto3.reto3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){

        return reservationCrudRepository.findById(id);

    }

    public Reservation save(Reservation resv){

        return reservationCrudRepository.save(resv);
    }

    public void delete(Reservation resv){
        reservationCrudRepository.delete(resv);
    }
    
}

