/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example02JB.demo02JB.Repositorio;

import com.example02JB.demo02JB.Interface.MessageInterface;
import com.example02JB.demo02JB.Interface.MessageInterface;
import com.example02JB.demo02JB.Modelo.Message;
import com.example02JB.demo02JB.Modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository

public class MessageRepositorio {
    
    @Autowired
    private MessageInterface messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    public void delete (Message message){
        messageCrudRepository.delete(message);
    }   
}
