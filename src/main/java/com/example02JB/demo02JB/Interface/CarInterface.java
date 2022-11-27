/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example02JB.demo02JB.Interface;

import com.example02JB.demo02JB.Modelo.Car;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */ 
public interface CarInterface extends CrudRepository <Car, Integer>{
    
}
