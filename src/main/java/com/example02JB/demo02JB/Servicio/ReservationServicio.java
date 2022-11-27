/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example02JB.demo02JB.Servicio;


import com.example02JB.demo02JB.Modelo.Reservation;
import com.example02JB.demo02JB.Repositorio.ReservationRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service

public class ReservationServicio {

    @Autowired    
    private ReservationRepositorio reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null){
        return reservationRepository.save(reservation);
    }else{
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
           if (reservation1.isEmpty()){
                return reservationRepository.save(reservation);
                
        } else {
            return reservation;
        }
    }
}
  
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation(int reservationId){
        Boolean d=getReservation(reservationId).map(reservation ->{
            reservationRepository.delete(reservation);
            return true;
        }) .orElse(false);
        return d;
    }
}