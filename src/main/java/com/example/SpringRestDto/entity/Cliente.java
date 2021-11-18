package com.example.SpringRestDto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name="Clientes")
public class Cliente {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer dni;


    private String nombre;



}
