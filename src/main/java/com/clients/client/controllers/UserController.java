package com.clients.client.controllers;

import com.clients.client.models.UserModel;
import com.clients.client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

/*
Anotaciones

@Component es el estereotipo principal, indica que la clase anotada es un component (o un Bean de Spring).
@Repository, @Service y @Controller son especializaciones de @Component para casos concretos (persistencia, servicios y presentación).
@Autowired sirve para inyectar un Bean usando la autodetección de Spring.
@Qualifier Si tenemos varios Beans que puedan aplicar, como por ejemplo 2 DataSources usaré el @Qualifier:
 */

@RestController // anortación que de de ser empleada en la capa de presentación presentación, para peticiones de tipo REST.
@RequestMapping("/user")
public class UserController {

    @Autowired //se emplea para generar la inyección de dependenciaa de un tipo de Objeto que pertenece a una clase con la @Component.
    UserService userService;

    //Obtener lista de usuarios
    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    //Actualizar usuario
    @PostMapping()
    public UserModel saveUser (@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    //Obtner por ID
    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getUserById(id);
    }

    //obtener por prioridad
    @GetMapping( path = "/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority){
        return this.userService.getByPriority(priority);
    }

    @DeleteMapping ( path = ("/{id}"))
    public String deleteUser (@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        String result = (ok) ?  "se elimino el usuario con id "+ id : "No se puedo  eliminar el usuario con id "+ id;
        return result;
    }
}
