package com.clients.client.services;

import com.clients.client.models.UserModel;
import com.clients.client.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service // anotación que debe de ser empleada para la capa de servicios (facade) y logica de negocio.
public class UserService {

    @Autowired //No hay que instanciarla
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
       return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser (UserModel userModel){
        return userRepository.save(userModel);
    }

    //Clase Optional  evita error con los nulos si no existe el ID
    public Optional<UserModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByPriority (Integer priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser (Long id){
        try {
            userRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
