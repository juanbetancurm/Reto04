/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example02JB.demo02JB.Servicio;

import com.example02JB.demo02JB.Modelo.Car;
import com.example02JB.demo02JB.Repositorio.CarRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service

public class CarServicio {

    @Autowired    
    private CarRepositorio carRepository;
    
    public List<Car> getAll(){
        return carRepository.getAll();
    }
    public Optional<Car> getCar(int carId){
        return carRepository.getCar(carId);
    }
    
    public Car save(Car car){
        if (car.getIdCar() == null){
        return carRepository.save(car);
    }else{
            Optional<Car> car1 = carRepository.getCar(car.getIdCar());
           if (car1.isEmpty()){
                return carRepository.save(car);
                
        } else {
            return car;
        }
        }
    }
    
    public Car update(Car car){
        if(car.getIdCar()!=null){
            Optional<Car> e=carRepository.getCar(car.getIdCar());
            if(!e.isEmpty()){
                if(car.getName()!=null){
                    e.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    e.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    e.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null){
                    e.get().setDescription(car.getDescription());
                }
                if(car.getGama()!=null){
                    e.get().setGama(car.getGama());
                }
                carRepository.save(e.get());
                return e.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }
    
    public boolean deleteCar(int carId){
        Boolean d=getCar(carId).map(car ->{
            carRepository.delete(car);
            return true;
        }) .orElse(false);
        return d;
    }
}
