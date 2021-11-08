package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.reto3.model.Reservation;
import com.example.reto3.reto3.repository.ReservationRepository;

@Service
/**
 *  Tabla reservation
 */
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
/**
 *  Creación de método get
 */
    public List<Reservation> getAll(){

        return reservationRepository.getAll();

    }
/**
 *  Creación de método get
 */
    public Optional<Reservation> getReservation(int id){

        return reservationRepository.getReservation(id);
    }
/**
 *  Creación de método post
 */
    public Reservation save(Reservation clt){

        if(clt.getIdReservation()==null){

            return reservationRepository.save(clt);
        }

        else{

            Optional<Reservation> cltaux=reservationRepository.getReservation(clt.getIdReservation());
            if(cltaux.isEmpty()){

                return reservationRepository.save(clt);
            }
            else{

                return clt;
            }
        }
    }
/**
 *  Creación de método put
 */
    public Reservation update(Reservation clt){
        if(clt.getIdReservation()!=null){
            Optional<Reservation>find= reservationRepository.getReservation(clt.getIdReservation());
            if(!find.isEmpty()){
                if(clt.getStartDate()!=null){
                    find.get().setStartDate(clt.getStartDate());
                }
                if(clt.getDevolutionDate()!=null){
                    find.get().setDevolutionDate(clt.getDevolutionDate());
                }
                if(clt.getStatus()!=null){
                    find.get().setStatus(clt.getStatus());
                }
                if(clt.getScore()!=null){
                    find.get().setScore(clt.getScore());
                }
                return reservationRepository.save(find.get());
            }
        }
        return clt;
    }
/**
 *  Creación de método delete
 */
    public boolean deleteReservation(int id){
        Optional<Reservation> clt=getReservation(id);
        if(!clt.isEmpty()){
            reservationRepository.delete(clt.get());
            return true;
        }
        return false;
        }    
}

