package com.clients.client.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Una de las grandes ventajas de JPA es que nos permite manipular la base de datos a través de objetos,
estos objetos son conocidos como Entity. Las cuales son clases comunes y corrientes
también llamada POJO’s (Plain Old Java Objects).

Estas clases tiene la particularidad de ser clases que están mapeadas contra una tabla de la base de datos,
dicho mapeo se lleva a cabo generalmente mediante Anotaciones.
Dichas anotaciones brindan los suficientes metadatos  como para poder por relacionar las clases contra las tablas
y las propiedades contra las columnas.

Es de esta forma que JPA es capaz de interactuar con la base de datos a través de las clases.

@Entity : sirve únicamente para indicarle a JPA que esa clase es una Entity

 */

@Setter //Lomkok library
@Getter //Lomkok library
@Entity//JPA debe de ser capaz de identificar que clases son Entity para de esta forma poderlas administrar por EntityManager
@Table(name = "user") //JPA library annotation @Table = table name
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auteincremente
    @Column(unique = true, nullable = false) //columna unica y nulla
    private Long id;

    private String name;
    private String email;
    private Integer priority;
}
