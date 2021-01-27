package com.clients.client.repositories;

import com.clients.client.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // anotación que debe de ser empleada en la capa de persitiencia.
public interface UserRepository extends CrudRepository<UserModel, Long> {

    //busca los usuario por prioridad
    public abstract ArrayList<UserModel> findByPriority(Integer priority);

}
